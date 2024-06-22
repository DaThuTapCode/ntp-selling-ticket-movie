package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.model.Theater;
import com.trongphu.ticketmovie.repository.ShowTimeRepository;
import com.trongphu.ticketmovie.responsedata.ShowTimeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Trong Phu
 */
@Service
@RequiredArgsConstructor
public class ShowTimeService implements IShowTimeService{

    private final ShowTimeRepository showTimeRepository;

    @Override
    public List<ShowTimeResponse> getAll() {
        return showTimeRepository.findAll().stream().map(ShowTimeResponse::convertToShowTimeDTO).toList();
    }

    @Override
    public Optional<ShowTime> getById(Long id) {
        return showTimeRepository.findById(id);
    }

    @Override
    public List<ShowTimeResponse> getByMovieId(Long movieId) {
        return showTimeRepository.findByMovie_Id(movieId).stream().map(ShowTimeResponse::convertToShowTimeDTO).toList();
    }

    @Override
    public List<ShowTimeResponse> getByScreensId(Long screensId) {
        return showTimeRepository.findByScreen_Id(screensId).stream().map(ShowTimeResponse::convertToShowTimeDTO).toList();
    }

    @Override
    public List<ShowTimeResponse> getShowTimesByTheater(Theater theater) {
         return showTimeRepository.findByScreen_Theater(theater).stream().map(ShowTimeResponse::convertToShowTimeDTO).toList();
    }

    @Override
    public List<ShowTime> findAllByMovieId(Long movieId, LocalDate showdate, LocalTime showtime) {
        return showTimeRepository.findAllByMovieId(movieId, showdate, showtime);
    }

    @Override
    public List<ShowTime> findAllByMovieId2(Long movieId, LocalDate showdate) {
        return showTimeRepository.findAllByMovieId2(movieId, showdate);
    }

    /**
     * ADMIN*/

    @Override
    public List<ShowTime> getByTheaterScreensShowDate(Long theaterId, Long screenId, LocalDate showdate) {
        return showTimeRepository.findShowTimeByTheaterAndScreenAndShowdate(theaterId, screenId, showdate);
    }

    @Override
    public ShowTime createShowTime(ShowTime showTime) {
       return showTimeRepository.save(showTime);
    }
}
