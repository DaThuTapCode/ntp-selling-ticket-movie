package com.trongphu.ticketmovie.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trongphu.ticketmovie.model.Movie;
import com.trongphu.ticketmovie.model.Screen;
import com.trongphu.ticketmovie.model.ShowTime;
import lombok.Builder;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by Trong Phu on 6/2/2024 03:00:12
 *
 * @author Trong Phu
 */
@Data
@Builder
public class ShowTimeDTO {

    private Long id;

    private String moviename;

    private String screenname;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate showdate;

    private LocalTime showtime;

    public static ShowTimeDTO convertToShowTimeDTO(ShowTime showTime){
        ShowTimeDTO showTimeDTO = ShowTimeDTO
                .builder()
                .id(showTime.getId())
                .moviename(showTime.getMovie() != null ? showTime.getMovie().getTitle() : null)
                .screenname(showTime.getScreen() != null ? showTime.getScreen().getName() : null)
                .showdate(showTime.getShowdate() != null ? showTime.getShowdate() : null)
                .showtime(showTime.getShowtime())
                .build();
        return showTimeDTO;

    }

}
