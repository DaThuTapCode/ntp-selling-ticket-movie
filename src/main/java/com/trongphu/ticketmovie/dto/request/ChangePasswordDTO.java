package com.trongphu.ticketmovie.dto.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Trong Phu on 6/23/2024 22:57:50
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangePasswordDTO {

    @Size(min = 6, max = 200, message = "Mật khẩu phải từ 6 - 200 ký tự!")
    private String passwordCurrent;

    @Size(min = 6, max = 200, message = "Mật khẩu phải từ 6 - 200 ký tự!")
    private String passwordNew;

    @Size(min = 6, max = 200, message = "Mật khẩu phải từ 6 - 200 ký tự!")
    private String passwordConfirm;

}
