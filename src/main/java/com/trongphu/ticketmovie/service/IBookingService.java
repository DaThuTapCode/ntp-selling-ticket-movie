package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.BookingDTO;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
public interface IBookingService {
    List<BookingDTO> findAll();
}
