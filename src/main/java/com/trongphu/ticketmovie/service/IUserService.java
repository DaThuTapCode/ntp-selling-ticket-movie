package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.UserDTO;
import com.trongphu.ticketmovie.dto.respone.UserLoginResponse;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.exception.ExistsDataException;
import com.trongphu.ticketmovie.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Trong Phu
 */
public interface IUserService {
    List<UserDTO> findAllUser();
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);

    User createUser(UserDTO userDTO) throws DataNotFoundException, Exception;

    String login(String userName, String password) throws DataNotFoundException;

    void changePassword(User user);

    UserDTO changeInfoUser(User user) throws ExistsDataException;

    boolean existEmail(String email);

    Page<User> findPageAllUser(Pageable pageable);

}
