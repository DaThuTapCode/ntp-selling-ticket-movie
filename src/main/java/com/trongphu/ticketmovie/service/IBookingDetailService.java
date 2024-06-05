package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.BookingDetailDTO;
import com.trongphu.ticketmovie.model.BookingDetail;

/**
 *
 * @author Trong Phu
 */
public interface IBookingDetailService {

    BookingDetailDTO save(BookingDetail bookingDetail);

}
