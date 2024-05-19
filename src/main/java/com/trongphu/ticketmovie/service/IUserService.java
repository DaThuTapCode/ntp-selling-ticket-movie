package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.UserDTO;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDTO> findAllUser();
    Optional<User> findById(Long id);

    User createUser(UserDTO userDTO) throws DataNotFoundException;

    String login(String userName, String password);
}
