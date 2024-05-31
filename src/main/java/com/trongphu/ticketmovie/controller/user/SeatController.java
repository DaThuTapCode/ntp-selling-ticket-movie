package com.trongphu.ticketmovie.controller.user;

import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.service.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Trong Phu on 5/27/2024 20:22:10
 *
 * @author Trong Phu
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/seat")
public class SeatController {

    private final SeatService seatService;

    @GetMapping("/all")
    public ResponseData getAll(){
        return new ResponseData(HttpStatus.OK.value(),"Get all seat", seatService.getAll());
    }

    @GetMapping("/{screenid}")
    private ResponseData getSeatByIDScreen(
            @PathVariable("screenid") Long screenid
    ){
        return new ResponseData(HttpStatus.OK.value(), "Get seat by screens id", seatService.getSeatByScreenId(screenid));
    }
}
