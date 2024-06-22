package com.trongphu.ticketmovie.responsedata;

import com.trongphu.ticketmovie.model.Seat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Trong Phu on 5/27/2024 20:33:06
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatResponse {
    private Long id;

    private Long screenid;

    private String seatrow;

    private String seatnumber;


    private String type;

    private String status;

    public static SeatResponse convertToSeatReponse(Seat seat){
        SeatResponse seatResponse = SeatResponse.builder()
                .id(seat.getId())
                .screenid(seat.getScreen().getId())
                .seatrow(seat.getSeatrow())
                .seatnumber(seat.getSeatnumber())
                .type(seat.getType())
                .status(seat.getStatus())
                .build();
        return seatResponse;
    }
}
