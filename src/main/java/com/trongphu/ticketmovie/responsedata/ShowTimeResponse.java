package com.trongphu.ticketmovie.responsedata;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.model.Theater;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by Trong Phu on 5/27/2024 21:17:31
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowTimeResponse {

    private Long id;

    private Long movieId;

    private Long screenId;

    private Theater theater;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy"
//            , timezone = "Asia/Ho_Chi_Minh"
            )
    private LocalDate showdate;

    private LocalTime showtime;

    public static ShowTimeResponse convertToShowTimeDTO(ShowTime showTime){
        ShowTimeResponse showTimeDTO = ShowTimeResponse.builder()
                .id(showTime.getId())
                .movieId(showTime.getMovie().getId())
                .screenId(showTime.getScreen().getId())
                .showdate(showTime.getShowdate())
                .showtime(showTime.getShowtime())
                .theater(showTime.getScreen().getTheater())
                .build();

        return showTimeDTO;
    }
}
