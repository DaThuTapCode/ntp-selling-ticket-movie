package com.trongphu.ticketmovie.controller.user;

import com.trongphu.ticketmovie.component.JwtTokenUtil;
import com.trongphu.ticketmovie.dto.request.UserDTO;
import com.trongphu.ticketmovie.dto.request.UserLoginDTO;
import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.dto.respone.ResponseError;
import com.trongphu.ticketmovie.dto.respone.UserLoginResponse;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.model.User;
import com.trongphu.ticketmovie.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Trong Phu
 */
@RestController
@RequestMapping("${api.prefix}/users")
@RequiredArgsConstructor
public class UserController {


    @GetMapping("/hihi")
    public ResponseEntity<String> hihi() {
        return ResponseEntity.ok("Nguyễn Trọng Phú Tập code nè");
    }

    private final UserService userService;

    private final JwtTokenUtil jwtTokenUtil;

    @GetMapping("")
    public ResponseEntity<List> findAllUser() {
        return ResponseEntity.ok(userService.findAllUser());
    }

    /**
     * API lấy ra user theo id
     * GET http://localhost:8080/api/v1/users/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable("id") Long id) {
        System.out.println("dm");
        return ResponseEntity.ok(userService.findById(id));
    }

    /**
     * API Đăng ký tài khoản
     * POST http://localhost:8080/api/v1/users/register
     */
    @PostMapping("/register")
    public ResponseData createUser(@Valid @RequestBody UserDTO userDTO) throws Exception {
        User u = userService.createUser(userDTO);
        return new ResponseData(HttpStatus.CREATED.value(), "Register new user successfully!", u);
    }


    /**
     * API đăng nhập
     * POST http://localhost:8080/api/v1/users/login
     */
    @PostMapping("/login")
    public ResponseData login(@Valid @RequestBody UserLoginDTO userLoginDTO) throws DataNotFoundException {
        /**
         * Kiểm tra đăng nhập và sinh token
         * */
        String token = userService.login(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        System.out.println(jwtTokenUtil.extractUserName(token));
        Optional<User> user = userService.findByUsername(jwtTokenUtil.extractUserName(token));
        return new ResponseData(
                HttpStatus.ACCEPTED.value(),
                "Login successfully!",
                UserLoginResponse.
                        builder().
                        message("Login successfully!")
                        .token(token)
                        .userDTO(UserDTO.builder().username(user.get().getUsername()).status(user.get().getStatus()).role(user.get().getRole().getId()).email(user.get().getEmail()).build())
                        .build());
    }
}
