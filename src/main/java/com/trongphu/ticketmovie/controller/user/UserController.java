package com.trongphu.ticketmovie.controller.user;

import com.trongphu.ticketmovie.component.JwtTokenUtil;
import com.trongphu.ticketmovie.dto.request.ChangeInfoUserDTO;
import com.trongphu.ticketmovie.dto.request.ChangePasswordDTO;
import com.trongphu.ticketmovie.dto.request.UserDTO;
import com.trongphu.ticketmovie.dto.request.UserLoginDTO;
import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.dto.respone.ResponseError;
import com.trongphu.ticketmovie.dto.respone.UserLoginResponse;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.exception.ExistsDataException;
import com.trongphu.ticketmovie.model.User;
import com.trongphu.ticketmovie.service.UserService;
import com.trongphu.ticketmovie.util.FileImageUploadUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
        return new ResponseData(HttpStatus.CREATED.value(), "Đăng ký tài khoản mới thành công!", u);
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
                "Đăng nhập thành công!",
                UserLoginResponse.
                        builder().
                        message("Đăng nhập thành công!")
                        .token(token)
                        .userDTO(UserDTO
                                .builder()
                                .username(user.get().getUsername())
                                .status(user.get().getStatus())
                                .role(user.get().getRole().getId())
                                .email(user.get().getEmail())
                                .fullname(user.get().getFullname())
                                .image(user.get().getImage())
                                .build())
                        .build());
    }

    @PutMapping("/change-password")
    public ResponseEntity<ResponseData> changePassword(
             @RequestBody @Valid ChangePasswordDTO changePasswordDTO
             , HttpServletRequest req
            ) throws DataNotFoundException {

        String authHeader = req.getHeader("Authorization");
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            return new ResponseEntity<>(new ResponseError(HttpStatus.BAD_REQUEST.value(), "Lỗi chưa đăng nhập!"), HttpStatus.BAD_REQUEST);
        }
        final String token = authHeader.substring(7);
        final String username = jwtTokenUtil.extractUserName(token);
       User userChangePass =  userService.findByUsername(username).orElseThrow(() -> new DataNotFoundException("User không hợp lệ!"));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(passwordEncoder.matches(changePasswordDTO.getPasswordCurrent(), userChangePass.getPassword())){
            String newPass =
            passwordEncoder.encode(changePasswordDTO.getPasswordNew());
            userChangePass.setPassword(newPass);
            userService.changePassword(userChangePass);
            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Đổi mật khẩu thành công!"), HttpStatus.OK);
        }
       return new ResponseEntity<>(new ResponseError(HttpStatus.BAD_REQUEST.value(), "Có lỗi khi đổi mật khẩu!"), HttpStatus.BAD_REQUEST);
    }
    @PutMapping(value = "/change-info", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseData> changeInfo(
             @RequestBody @Valid ChangeInfoUserDTO changeInfoUserDTO
             , HttpServletRequest req
            ) throws DataNotFoundException, Exception {

        String authHeader = req.getHeader("Authorization");
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            return new ResponseEntity<>(new ResponseError(HttpStatus.BAD_REQUEST.value(), "Lỗi chưa đăng nhập!"), HttpStatus.BAD_REQUEST);
        }
        final String token = authHeader.substring(7);
        final String username = jwtTokenUtil.extractUserName(token);
       User userChangeInfo =  userService.findByUsername(username).orElseThrow(() -> new DataNotFoundException("User không hợp lệ!"));

       if (!userChangeInfo.getEmail().equals(changeInfoUserDTO.getEmail())){
         boolean check =   userService.existEmail(userChangeInfo.getEmail());
         if(check){
             throw  new ExistsDataException("Email đã tồn tại");
         }
       }
       MultipartFile file = changeInfoUserDTO.getFile();
        if(file != null && !file.isEmpty()){
            if(file.getSize() > 1 * 1024 * 1024){
                return new ResponseEntity<>(new ResponseError(HttpStatus.PAYLOAD_TOO_LARGE.value(), "File lớn hơn 1mb"),HttpStatus.PAYLOAD_TOO_LARGE) ;
            }
            String contentTypeFile = file.getContentType();
            if(contentTypeFile == null || !contentTypeFile.startsWith("image/")) {
                return new ResponseEntity<>(new ResponseError(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), "File ảnh không hợp lệ!"),HttpStatus.UNSUPPORTED_MEDIA_TYPE);
            }
            FileImageUploadUtil.deleteFile(userChangeInfo.getImage());
            String filename = FileImageUploadUtil.storeFile(file);
            userChangeInfo.setImage(filename);
            userChangeInfo.setEmail(changeInfoUserDTO.getEmail());
            userChangeInfo.setFullname(changeInfoUserDTO.getFullname());
            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Cập nhật thông tin thành công!",userService.changeInfoUser(userChangeInfo)), HttpStatus.OK);
        }

        userChangeInfo.setEmail(changeInfoUserDTO.getEmail());
        userChangeInfo.setFullname(changeInfoUserDTO.getFullname());
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Cập nhật thông tin thành công!",userService.changeInfoUser(userChangeInfo)), HttpStatus.OK);
    }
}
