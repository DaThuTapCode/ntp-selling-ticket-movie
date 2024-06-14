package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.model.Theater;
import com.trongphu.ticketmovie.responsedata.ShowTimeResponse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Trong Phu
 */
public interface IShowTimeService {
    List<ShowTimeResponse> getAll();

    Optional<ShowTime> getById(Long id);

    List<ShowTimeResponse> getByMovieId(Long movieId);

    List<ShowTimeResponse> getByScreensId(Long screensId);

    List<ShowTimeResponse> getShowTimesByTheater(Theater theater);

    List<ShowTime> findAllByMovieId(Long movieId, LocalDate showdate, LocalTime showtime);

    /**
     * ADMIN*/
    List<ShowTime> getByTheaterScreensShowDate(Long theaterId, Long screenId, LocalDate showdate);

    ShowTime createShowTime(ShowTime showTime);

}
