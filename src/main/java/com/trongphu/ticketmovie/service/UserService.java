package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.component.JwtTokenUtil;
import com.trongphu.ticketmovie.dto.request.UserDTO;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.exception.ExistsDataException;
import com.trongphu.ticketmovie.exception.PermissionDenyException;
import com.trongphu.ticketmovie.model.Role;
import com.trongphu.ticketmovie.model.User;
import com.trongphu.ticketmovie.repository.RoleRepository;
import com.trongphu.ticketmovie.repository.UserRepository;
import com.trongphu.ticketmovie.util.StatusUserEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Trong Phu
 */
@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    //@Autowired
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public List<UserDTO> findAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        //return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(UserDTO userDTO) throws Exception {
        String userName = userDTO.getUsername();
        String email = userDTO.getEmail();

        if (userRepository.existsByUsername(userName)) {
            throw new ExistsDataException("User name already exists!");
        }

        if(userRepository.existsByEmail(email)){
            throw new ExistsDataException("Email already exists!");
        }

        if (!userDTO.getPassword().equals(userDTO.getRetypepassword())) {
            throw  new ExistsDataException("Password dose is not match!");
        }

        Role role = roleRepository.findById(userDTO.getRole())
                .orElseThrow(() -> new DataNotFoundException("Role not found!"));
        if(role.getName().equals(Role.ADMIN)){
            throw new PermissionDenyException("You can not register account ADMIN!");
        }
        User newUser = User.builder()
                .fullname(userDTO.getFullname())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .status(StatusUserEnum.ACTIVE)
                .facebookacountid(userDTO.getFacebookacountid())
                .googleacountid(userDTO.getGoogleacountid())
                .createdat(LocalDate.now())
                .updateat(LocalDate.now())
                .build();
        newUser.setRole(role);

        //Kiem tra neu co account id, khong yeu cau password
        if (userDTO.getFacebookacountid() == 0 && userDTO.getGoogleacountid() == 0) {
            String password = userDTO.getPassword();
            String endcodedPassword = passwordEncoder.encode(password);
            newUser.setPassword(endcodedPassword);
        }

        return userRepository.save(newUser);
    }

    @Override
    public String login(String userName, String password) throws DataNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(userName);
        if (optionalUser.isEmpty()) {
            throw new DataNotFoundException("Invalid User name or password!");
        }
        if (optionalUser.get().getFacebookacountid() == 0
                && optionalUser.get().getGoogleacountid() == 0) {
            if (!passwordEncoder.matches(password, optionalUser.get().getPassword())){
                throw  new DataNotFoundException("Invalid User name or password!!");
            }
        }

        //authenticate with java Spring security
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                userName, password, optionalUser.get().getAuthorities()
        );
        authenticationManager.authenticate(authenticationToken);
        return jwtTokenUtil.gennerateToke(optionalUser.get());
    }


    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setImage(user.getImage());
        userDTO.setCreatedat(user.getCreatedat());
        userDTO.setUpdateat(user.getUpdateat());
        userDTO.setStatus(user.getStatus());
        userDTO.setRole(user.getRole().getId());
        userDTO.setFullname(user.getFullname());
        return userDTO;
    }


}
