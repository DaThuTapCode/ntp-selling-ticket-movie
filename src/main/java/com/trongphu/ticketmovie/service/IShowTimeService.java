package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.model.Theater;
import com.trongphu.ticketmovie.responsedata.ShowTimeResponse;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Trong Phu
 */
public interface IShowTimeService {
    List<ShowTimeResponse> getAll();

    List<ShowTimeResponse> getByMovieId(Long movieId);

    List<ShowTimeResponse> getByScreensId(Long screensId);

    List<ShowTimeResponse> getShowTimesByTheater(Theater theater);

    List<ShowTime> findAllByMovieId(Long movieId, LocalDate showdate, LocalTime showtime);
}
