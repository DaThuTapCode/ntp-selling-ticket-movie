package com.trongphu.ticketmovie.controller.admin;

import com.trongphu.ticketmovie.dto.request.SeatDTO;
import com.trongphu.ticketmovie.dto.request.UserDTO;
import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.dto.respone.ResponseError;
import com.trongphu.ticketmovie.exception.ExistsDataException;
import com.trongphu.ticketmovie.model.Seat;
import com.trongphu.ticketmovie.responsedata.SeatResponse;
import com.trongphu.ticketmovie.service.SeatService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Trong Phu on 6/19/2024 22:27:46
 *
 * @author Trong Phu
 */
@RestController
@RequestMapping("${api.prefix}/admin/seat")
@RequiredArgsConstructor
public class ADSeatController {
    private final SeatService seatService;

    @PostMapping("create")
    public ResponseEntity<ResponseData> createSeatNormal(
            @Valid @RequestBody SeatDTO seatDTO
    ) throws Exception {
        SeatDTO seatDTOR = seatService.createSeat(seatDTO);
        return new ResponseEntity<>(new ResponseData(HttpStatus.CREATED.value(), "Tạo ghế thành công!", seatDTOR), HttpStatus.CREATED);
    }




    @PostMapping("create-fast")
    public ResponseEntity<ResponseData> createSeatFast(
            @Valid @RequestBody SeatDTO seatDTO
    ) {
        return new ResponseEntity<>(new ResponseData(HttpStatus.CREATED.value(), "Tạo ghế thành công!", seatDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get-by-screen/{screenid}")
    public ResponseEntity<ResponseData> getByScreenId(
            @PathVariable Long screenid
    ) {
        List<SeatResponse> seatDTOList = seatService.getSeatByScreenId(screenid);
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Get ghế by screen id: " + screenid, seatDTOList), HttpStatus.OK);
    }

    @PutMapping("/update-type-seat/{id}")
    public ResponseEntity<ResponseData> updateTypeSeat(
            @PathVariable Long id,
            @RequestParam String newType
    ) throws Exception {
        SeatResponse seatResponse = seatService.updateTypeSeat(id, newType);
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Update kiểu ghế thành công!", seatResponse), HttpStatus.OK);
    }


    @DeleteMapping("/delete-seat/{id}")
    public ResponseEntity<ResponseData> deleteSeat(
            @PathVariable Long id
    ) throws Exception {
        seatService.delete(id);
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Xóa ghế thành công!"), HttpStatus.OK);
    }

}
