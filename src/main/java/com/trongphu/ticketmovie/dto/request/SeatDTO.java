package com.trongphu.ticketmovie.dto.request;

import com.trongphu.ticketmovie.model.Screen;
import com.trongphu.ticketmovie.model.Seat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Trong Phu on 5/27/2024 20:29:53
 *
 * @author Trong Phu
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SeatDTO {

    private Long id;

    private Long screenid;

    private String seatrow;

    private String seatnumber;


    private String type;

    private String status;

    public static SeatDTO convertToSeatDTO(Seat seat){
        SeatDTO seatDTO = SeatDTO
                .builder()
                .id(seat.getId())
                .screenid(seat.getScreen().getId())
                .seatrow(seat.getSeatrow())
                .seatnumber(seat.getSeatnumber())
                .type(seat.getType())
                .status(seat.getStatus())
                .build();
        return seatDTO;
    }

}
