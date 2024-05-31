package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.model.Seat;
import com.trongphu.ticketmovie.responsedata.SeatResponse;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
public interface ISeatService {
    List<SeatResponse> getAll();

    List<SeatResponse> getSeatByScreenId(Long screenid);

}
