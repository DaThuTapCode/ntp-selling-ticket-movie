package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.UserDTO;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.model.Role;
import com.trongphu.ticketmovie.model.User;
import com.trongphu.ticketmovie.repository.RoleRepository;
import com.trongphu.ticketmovie.repository.UserRepository;
import com.trongphu.ticketmovie.util.StatusUserEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService{

    //@Autowired
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;


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
    public User createUser(UserDTO userDTO) throws DataNotFoundException {
        //Kiem  tra userName da ton tai hay chua
        String userName = userDTO.getUsername();
        if(userRepository.existsByUsername(userName)){
            throw new DataIntegrityViolationException("User name already exists!");
        }
        // chuyen doi UserDTO sang User
        User newUser = User.builder()
                .fullname(userDTO.getFullname())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .status(StatusUserEnum.ACTIVE)
                .facebookacountid(userDTO.getFacebookacountid())
                .googleacountid(userDTO.getGoogleacountid())
                .build();
        Role role = roleRepository.findById(userDTO.getRole())
                .orElseThrow(() -> new DataNotFoundException("Role not found"));
        newUser.setRole(role);

        //Kiem tra neu co account id, khong yeu cau password
        if (userDTO.getFacebookacountid() == 0 && userDTO.getGoogleacountid() == 0) {
            String password = userDTO.getPassword();
            //String endcodedPassword = passwordEncoder.encode(password);

            //newUser.setPassword(endcodedPassword);
        }

        return  userRepository.save(newUser);
    }

    @Override
    public String login(String userName, String password) {
        //Lieen quan nhieu den security, se lam trong phan security
        return null;
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
        // Chuyển đổi các UserRole sang UserRoleDTO
//        List<UserRoleDTO> userRoleDTOs = user.getUseroles().stream()
//                .map(this::convertUserRoleToDTO)
//                .collect(Collectors.toList());
//        userDTO.setUseroles(userRoleDTOs);
        return userDTO;
    }

//    private UserRoleDTO convertUserRoleToDTO(UserRole userRole) {
//        UserRoleDTO userRoleDTO = new UserRoleDTO();
//        userRoleDTO.setId(userRole.getId());
//        userRoleDTO.setUserid(userRole.getUser().getId());
//        userRoleDTO.setRoleid(userRole.getRole().getId());
//        userRoleDTO.setRolename(userRole.getRole().getName());
//        return userRoleDTO;
//    }

}
