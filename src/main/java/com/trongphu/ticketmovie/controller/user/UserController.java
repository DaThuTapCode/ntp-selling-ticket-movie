package com.trongphu.ticketmovie.controller.user;

import com.trongphu.ticketmovie.dto.request.UserDTO;
import com.trongphu.ticketmovie.dto.request.UserLoginDTO;
import com.trongphu.ticketmovie.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 *
 * @author Trong Phu
 */
@RestController
@RequestMapping("${api.prefix}/users")
@RequiredArgsConstructor
public class UserController {


    @GetMapping("/hihi")
    public ResponseEntity<String> hihi(){
        return ResponseEntity.ok("Nguyễn Trọng Phú Tập code nè");
    }


    private final UserService userService;

    @GetMapping("")
    public ResponseEntity<List> findAllUser() {

        return ResponseEntity.ok(userService.findAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable("id") Long id) {
        System.out.println("dm");
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO,
                                        BindingResult result
    ) {
        try {
            if (result.hasErrors()) {
                List<String> errorMessage = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessage);
            }
            if (!userDTO.getPassword().equals(userDTO.getRetypepassword())) {
                return ResponseEntity.badRequest().body("Password dose is not match!");
            }
            userService.createUser(userDTO);
            return ResponseEntity.ok("Rigister successfully! |" + userDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        //Kiểm tra đăng nhập
        String token = userService.login(userLoginDTO.getUsername(), userLoginDTO.getPassword());


        // Trả về token
        return ResponseEntity.ok("Login success!");
    }
}
