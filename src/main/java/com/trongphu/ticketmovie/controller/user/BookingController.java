package com.trongphu.ticketmovie.controller.user;

import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.dto.respone.ResponseError;
import com.trongphu.ticketmovie.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Trong Phu on 5/24/2024
 *
 * @author Trong Phu
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/booking")
public class BookingController {

    private final BookingService bookingService;
    @GetMapping("/all")
    public ResponseData getALlBooking(){
        try {
            return new ResponseData(HttpStatus.OK.value(), "Tat ca booking", bookingService.findAll());

        }catch (Exception e){
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }


}
