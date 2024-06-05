package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.BookingDetailDTO;
import com.trongphu.ticketmovie.model.BookingDetail;
import com.trongphu.ticketmovie.repository.BookingDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Trong Phu
 */
@Service
@RequiredArgsConstructor
public class BookingDetailService implements IBookingDetailService{

    private final BookingDetailRepository bookingDetailRepository;

    @Override
    public BookingDetailDTO save(BookingDetail bookingDetail) {
        return BookingDetailDTO.convertToBookingDetailDTO(bookingDetailRepository.save(bookingDetail));
    }
}
