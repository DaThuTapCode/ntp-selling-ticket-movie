package com.trongphu.ticketmovie.dto.request;

import com.trongphu.ticketmovie.model.User;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Trong Phu on 6/2/2024 01:56:30
 *
 * @author Trong Phu
 */
@Data
@Builder
public class UserBookingDTO {
    private Long id;

    private String username;

    private String email;

    public static UserBookingDTO convertToUserBookingDTO(User user){
        UserBookingDTO userBookingDTO = UserBookingDTO
                .builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();

        return userBookingDTO;
    }
}
