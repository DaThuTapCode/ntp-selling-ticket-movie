package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.BookingDTO;
import com.trongphu.ticketmovie.model.Booking;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Trong Phu
 */
public interface IBookingService {
    /**
     * Lấy ra toàn bộ danh sách giao dịch đặt vé!
     * */
    List<BookingDTO> findAll();

    /**
     * Lấy ra danh sách toàn bộ giao dịch đặt vé của 1 người dùng
     * */
    List<BookingDTO> findByUsername(String username);

    /**
     * Lấy ra kết quả giao dich theo id*/
    BookingDTO findByIdBookingAndUserName(Long id, String username);

    /**
     * Lưu giao dịch vào cơ sở dữ liệu
     * */
    BookingDTO save(Booking booking);


    /**
     * Lấy ra danh sách booking theo showtime
     * */
    List<BookingDTO> getBookingByShowtime(Long idshowtime);



//    List<Booking> findByStatus(String status);
    Optional<Booking> finById(Long id);

}
