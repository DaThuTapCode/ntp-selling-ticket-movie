package com.trongphu.ticketmovie.controller.admin;

import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.dto.respone.ResponseError;
import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.responsedata.ShowTimeResponse;
import com.trongphu.ticketmovie.service.ShowTimeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @PostMapping("/create")
    public ResponseEntity<?> createNewShowTime(@RequestBody ShowTime showTime) {
        try {
            List<ShowTime> showTimeList = showTimeService.getByTheaterScreensShowDate(
                    showTime.getScreen().getTheater().getId(),
                    showTime.getScreen().getId(),
                    showTime.getShowdate()
            );


            LocalTime newShowTimeStart = showTime.getShowtime();
            LocalTime newShowTimeEnd = newShowTimeStart.plusMinutes(showTime.getMovie().getDuration());

            for (ShowTime existingShowTime : showTimeList) {
                LocalTime existingShowTimeStart = existingShowTime.getShowtime();
                LocalTime existingShowTimeEnd = existingShowTimeStart.plusMinutes(existingShowTime.getMovie().getDuration());

                if ((newShowTimeStart.isBefore(existingShowTimeEnd) && newShowTimeEnd.isAfter(existingShowTimeStart))) {

                    return new ResponseEntity<>(new ResponseError(HttpStatus.BAD_REQUEST.value(), "Thời gian suất chiếu đang đè lên thời gian chiếu khác!" + existingShowTimeEnd), HttpStatus.BAD_REQUEST);
                }
            }

            LocalDateTime dateTimeNow = LocalDateTime.now();

            LocalDateTime dateTimeOfShowtime = LocalDateTime.of(showTime.getShowdate(), showTime.getShowtime());


            if(dateTimeNow.isAfter(dateTimeOfShowtime)){
                return new ResponseEntity<>(new ResponseError(HttpStatus.BAD_REQUEST.value(), "Không thể thêm suất chiếu ở quá khứ!"), HttpStatus.BAD_REQUEST);
            }

            ShowTime createdShowTime = showTimeService.createShowTime(showTime);
            return new ResponseEntity<>(new ResponseData(HttpStatus.CREATED.value(), "Thêm suất chiếu thành công!", createdShowTime), HttpStatus.CREATED);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(new ResponseError(HttpStatus.BAD_REQUEST.value(), "Tạo suất chiếu không thành công! " + exception.getMessage()), HttpStatus.BAD_REQUEST);
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
