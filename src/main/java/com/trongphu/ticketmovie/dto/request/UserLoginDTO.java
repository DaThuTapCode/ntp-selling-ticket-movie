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

    @NotBlank(message = "Username is required!")
    private String username;

    @NotBlank(message = "Password is required!")
    private String password;

//    @Min(value = 1, message = "You must enter role id > 1")
//    private Long roleid;
}
