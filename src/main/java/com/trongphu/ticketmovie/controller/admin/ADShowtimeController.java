package com.trongphu.ticketmovie.controller.admin;

import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.responsedata.ShowTimeResponse;
import com.trongphu.ticketmovie.service.ShowTimeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Trong Phu on 6/8/2024 13:53:24
 *
 * @author Trong Phu
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/admin/showtimes")
public class ADShowtimeController {

    private final ShowTimeService showTimeService;

    @PostMapping("create")
    private ResponseEntity<ResponseData> createNewShowTime(
             @RequestBody ShowTime showTime
    )throws Exception {

        try {
            ShowTime showTime1 = showTimeService.createShowTime(showTime);
            return new ResponseEntity<>(new ResponseData(HttpStatus.CREATED.value(), "Thêm suất chiếu thành công!", showTime1), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseData(HttpStatus.BAD_REQUEST.value(), "Thêm suất chiếu looxi!", showTime), HttpStatus.BAD_REQUEST);

        }

    }


    @GetMapping("get-show-time-t-s/{theaterId}/{screenId}/{showdate}")
    private ResponseEntity<ResponseData> getShowTimeByTS(
            @PathVariable Long theaterId
            , @PathVariable Long screenId
            , @PathVariable LocalDate showdate
    ) {
        try {
            List<ShowTime> showTimes = showTimeService.getByTheaterScreensShowDate(theaterId, screenId, showdate);
            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "OK", showTimes), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "OK", e.getMessage()), HttpStatus.BAD_REQUEST);

        }

    }
}
