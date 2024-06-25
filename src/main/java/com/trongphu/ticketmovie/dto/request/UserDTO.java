package com.trongphu.ticketmovie.dto.request;

import com.trongphu.ticketmovie.util.StatusUserEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
/**
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private Long role;

    @Size(min = 3, max = 100, message = "Tên từ 3 đến 100 ký tự!")
    private String fullname;

    @NotBlank(message = "Tên đăng nhập không được để trống!")
    @Size(min = 3, max = 100, message = "Tên đăng nhập từ 3 - 100 ký tự!")
    private String username;

    @NotBlank(message = "Mật khẩu không được để trống!")
    @Size(min = 6, max = 200,message = "Mật khẩu từ 6 - 200 ký tự!")
    private String password;

    private Integer facebookacountid;

    private Integer googleacountid;

    private String retypepassword;

    @NotBlank(message = "Email không được trống!")
    private String email;

    private String image;

    private LocalDate createdat;

    private LocalDate updateat;

    private StatusUserEnum status;

//    public UserDTO(@NotBlank(message = "UserName must be not blank!") String username) {
//        this.username = username;
//    }
}
