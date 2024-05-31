package com.trongphu.ticketmovie.dto.request;

import com.trongphu.ticketmovie.util.StatusUserEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
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
public class UserDTO {

    private Long role;

    @Size(min = 3, max = 100, message = "Full name 3-100 character!")
    private String fullname;

    @NotBlank(message = "UserName must be not blank!")
    private String username;

    @NotBlank(message = "Password must be not blank!")
    @Size(min = 6, max = 200,message = "Pass word between 6 - 200 character!")
    private String password;

    private Integer facebookacountid;

    private Integer googleacountid;

    private String retypepassword;

    @NotBlank(message = "Email must be not blank!")
    private String email;

    private String image;

    private LocalDate createdat;

    private LocalDate updateat;

    private StatusUserEnum status;

    public UserDTO(@NotBlank(message = "UserName must be not blank!") String username) {
        this.username = username;
    }
}
