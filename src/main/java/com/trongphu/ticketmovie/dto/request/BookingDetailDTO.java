package com.trongphu.ticketmovie.dto.request;

import com.trongphu.ticketmovie.model.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Trong Phu on 6/2/2024 01:44:01
 *
 * @author Trong Phu
 */
@Data
@Builder
public class BookingDetailDTO {
    private Long id;

    private ShowTimeDTO showtime;

    private SeatDTO seat;

    private TheaterDTO theater;

    private BigDecimal price;

    public static BookingDetailDTO convertToBookingDetailDTO(BookingDetail bookingDetail) {
        BookingDetailDTO bookingDetailDTO = BookingDetailDTO
                .builder()
                .id(bookingDetail.getId())
                .showtime(ShowTimeDTO.convertToShowTimeDTO(bookingDetail.getShowtime()))
                .seat(SeatDTO.convertToSeatDTO(bookingDetail.getSeat()))
                .theater(TheaterDTO.convertToTheaterDTO(bookingDetail.getTheater()))
                .price(bookingDetail.getPrice())
                .build();
        return bookingDetailDTO;
    }
}
