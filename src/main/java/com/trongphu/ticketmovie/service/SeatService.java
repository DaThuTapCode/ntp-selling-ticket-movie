package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.model.Seat;
import com.trongphu.ticketmovie.repository.SeatRepository;
import com.trongphu.ticketmovie.responsedata.SeatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
@Service
@RequiredArgsConstructor
public class SeatService implements ISeatService{
    private final SeatRepository seatRepository;
    @Override
    public List<SeatResponse> getAll() {
        return seatRepository.findAll().stream().map(SeatResponse::convertToSeatReponse).toList();
    }

    @Override
    public List<SeatResponse> getSeatByScreenId(Long screenid) {
        return seatRepository.findByScreen_Id(screenid).stream().map(SeatResponse::convertToSeatReponse).toList();
    }
}
