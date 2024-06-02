package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.BookingDTO;
import com.trongphu.ticketmovie.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
@Service
@RequiredArgsConstructor
public class BookingService implements IBookingService{
    private final BookingRepository bookingRepository;
    @Override
    public List<BookingDTO> findAll() {
        return bookingRepository.findAll().stream().map(BookingDTO::convertoBookingDTO).toList();
    }
}
