package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.BookingDTO;
import com.trongphu.ticketmovie.model.Booking;
import com.trongphu.ticketmovie.repository.BookingRepository;
import com.trongphu.ticketmovie.util.StatusBooking;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
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
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

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
    public List<BookingDTO> getBookingByShowtime(Long idshowtime) {
        return bookingRepository.SeatIsBookedByShowTime(idshowtime).stream().map(BookingDTO::convertoBookingDTO).toList();
    }



    @Override
    public Optional<Booking> finById(Long id) {
        return bookingRepository.findById(id);
    }



@Scheduled(fixedRate = 10000) // Chạy mỗi 10 giây
public void cancelExpiredBooking() {
//    Timestamp expiryTime = Timestamp.valueOf(LocalDateTime.now().minusMinutes(1));
    // Chuyển Timestamp thành Calendar

    List<Booking> bookingList = bookingRepository.findBookingByStatus(StatusBooking.PENDING);
    logger.info("Scheduled task started");
    for (Booking booking : bookingList) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(booking.getBookingdate().getTime());
        // Tăng thời gian lên 5 phút
        calendar.add(Calendar.MINUTE, 5);
        // Chuyển lại thành Timestamp
        Timestamp newDateBooking = new Timestamp(calendar.getTimeInMillis());
        Timestamp now =  Timestamp.valueOf(LocalDateTime.now());
        if (now.after(newDateBooking)) {
            booking.setStatus(StatusBooking.CANCELED);
            bookingRepository.save(booking);
        }
    }
    logger.info("Scheduled task finished");
}
}
