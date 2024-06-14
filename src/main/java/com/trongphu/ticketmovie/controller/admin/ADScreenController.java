package com.trongphu.ticketmovie.controller.admin;

import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.dto.respone.ResponseError;
import com.trongphu.ticketmovie.model.Screen;
import com.trongphu.ticketmovie.model.Theater;
import com.trongphu.ticketmovie.service.ScreenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Trong Phu on 6/8/2024 13:53:51
 *
 * @author Trong Phu
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/admin/screens")
public class ADScreenController {
    private final ScreenService screenService;

    /**
     * API Lấy ra screen theo theater;
     * Get
     */
    @GetMapping("/get-by-theater/{theaterId}")
    public ResponseEntity<ResponseData> getScreensByTheater(@PathVariable("theaterId") Long theaterId) {
        try {
            Theater theater = Theater.builder().id(theaterId).build();
            List<Screen> screenList = screenService.getScreensByTheater(theater);
            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Get all screens by theater", screenList), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}

