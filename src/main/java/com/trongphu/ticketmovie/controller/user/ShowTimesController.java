package com.trongphu.ticketmovie.controller.user;

import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.dto.respone.ResponseError;
import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.model.Theater;
import com.trongphu.ticketmovie.responsedata.ShowTimeResponse;
import com.trongphu.ticketmovie.service.ShowTimeService;
import com.trongphu.ticketmovie.util.TimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Trong Phu on 5/27/2024 21:15:58
 *
 * @author Trong Phu
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/showtime")
public class ShowTimesController {
    private final ShowTimeService showTimeService;

    @GetMapping("/all")
    public ResponseData getAll() {
        return new ResponseData(HttpStatus.OK.value(), "Get all show time", showTimeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseData getById(
            @PathVariable Long id
    ) {
        return new ResponseData(HttpStatus.OK.value(), "Lấy showtime theo id", showTimeService.getById(id));
    }

    @GetMapping("/screenid/{screenId}")
    public ResponseData getByScreenId(
            @PathVariable("screenId") Long screenId
    ) {
        return new ResponseData(HttpStatus.OK.value(), "Get show time by Screen id", showTimeService.getByScreensId(screenId));
    }

    @GetMapping("/screen-theater")
    public ResponseData getByScreenTheater(
            @RequestBody Theater theater
    ) {
        return new ResponseData(HttpStatus.OK.value(), "Get show time by Screen id", showTimeService.getShowTimesByTheater(theater));
    }

    @GetMapping("/movie/{movieId}/{date}")
    public ResponseData getByMovie(@PathVariable("movieId") Long movieId,
                                   @PathVariable(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate showdate) {

        LocalTime showtime = LocalTime.now();

        if (showdate == null) {
            showdate = LocalDate.now();
        } else {
            LocalDate now = LocalDate.now();
            if (showdate.isBefore(now)) {
                return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Ngày tìm kiếm nhỏ hơn ngày hiện tại!");
            }
        }

        List<ShowTime> showTimeList;

        LocalDate now = LocalDate.now();

        if (showdate.equals(now)) {
            showTimeList = showTimeService.findAllByMovieId(movieId, showdate, showtime);
            return new ResponseData(HttpStatus.OK.value(), "Get all show time by Movie", showTimeList);
        }

        showTimeList = showTimeService.findAllByMovieId2(movieId, showdate);
        return new ResponseData(HttpStatus.OK.value(), "Get all show time by Movie", showTimeList);
    }

}
