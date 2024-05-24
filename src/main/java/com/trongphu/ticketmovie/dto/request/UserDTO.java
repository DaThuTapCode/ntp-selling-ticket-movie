package com.trongphu.ticketmovie.dto.request;

import com.trongphu.ticketmovie.util.StatusUserEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
/**
 *
 * @author Trong Phu
 */
@Data
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

    private Date createdat;

    private Date updateat;

    private StatusUserEnum status;

}
