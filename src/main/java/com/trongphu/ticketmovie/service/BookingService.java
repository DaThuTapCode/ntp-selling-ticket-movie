package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.BookingDTO;
import com.trongphu.ticketmovie.model.Booking;
import com.trongphu.ticketmovie.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<BookingDTO> findByUsername(String username) {
        return bookingRepository.findByUser_Username(username).stream().map(BookingDTO::convertoBookingDTO).toList();
    }

    @Override
    public BookingDTO save(Booking booking) {
        return BookingDTO.convertoBookingDTO(bookingRepository.save(booking));
    }

    @Override
    public Optional<Booking> finById(Long id) {
        return bookingRepository.findById(id);
    }

}
