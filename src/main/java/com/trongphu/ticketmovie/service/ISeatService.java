package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.SeatDTO;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.model.Seat;
import com.trongphu.ticketmovie.responsedata.SeatResponse;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Trong Phu
 */
public interface ISeatService {
    List<SeatResponse> getAll();

    SeatDTO createSeat(SeatDTO seatDTO) throws Exception;

    List<SeatResponse> getSeatByScreenId(Long screenid);


    Optional<Seat> findById(Long id);

    SeatResponse updateTypeSeat(Long id, String newType) throws Exception;

    void delete(Long id) throws Exception;
}
