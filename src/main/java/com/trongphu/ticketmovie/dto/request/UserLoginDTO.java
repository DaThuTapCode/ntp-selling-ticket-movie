package com.trongphu.ticketmovie.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author Trong Phu
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {

    @NotBlank(message = "Tên đăng nhập là bắt buộc!")
    private String username;

    @NotBlank(message = "Mật khẩu là bắt buộc!")
    private String password;

//    @Min(value = 1, message = "You must enter role id > 1")
//    private Long roleid;
}
