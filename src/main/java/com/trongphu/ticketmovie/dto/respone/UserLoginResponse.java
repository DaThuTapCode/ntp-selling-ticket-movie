package com.trongphu.ticketmovie.dto.respone;

import com.trongphu.ticketmovie.dto.request.UserDTO;
import com.trongphu.ticketmovie.dto.request.UserLoginDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Trong Phu on 5/23/2024
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserLoginResponse {
    private String message;

    private String token;

    private UserDTO userDTO;

}
