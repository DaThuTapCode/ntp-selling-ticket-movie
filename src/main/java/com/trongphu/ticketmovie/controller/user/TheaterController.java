package com.trongphu.ticketmovie.controller.user;

import com.trongphu.ticketmovie.dto.request.TheaterDTO;
import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.model.Theater;
import com.trongphu.ticketmovie.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Trong Phu on 5/24/2024
 *
 * @author Trong Phu
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/theaters")
public class TheaterController {

    private final TheaterService service;

    @GetMapping("/all")
    public ResponseData getAllTheater(){
        return new ResponseData(HttpStatus.ACCEPTED.value(), "List all theater!", service.getAllTheater());
    }

    @GetMapping("/{id}")
    public ResponseData getTheaterById(@PathVariable("id") Long id){
        return new ResponseData(HttpStatus.ACCEPTED.value(), "Theater get by id", service.getById(id));
    }


}
