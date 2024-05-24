package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.UserDTO;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.model.User;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Trong Phu
 */
public interface IUserService {
    List<UserDTO> findAllUser();
    Optional<User> findById(Long id);

    User createUser(UserDTO userDTO) throws DataNotFoundException, Exception;

    String login(String userName, String password) throws DataNotFoundException;
}
