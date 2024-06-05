package com.trongphu.ticketmovie.dto.request;

import com.trongphu.ticketmovie.model.Booking;
import com.trongphu.ticketmovie.model.User;
import com.trongphu.ticketmovie.util.StatusBooking;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Trong Phu on 6/2/2024 01:43:48
 *
 * @author Trong Phu
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {

    private Long id;

    @NotNull(message = "Người mua không được trống!")
    private UserBookingDTO user;

    private Timestamp bookingdate;

    @Min(value = 1, message = "Tổng tiền phải là số dương!")
    private BigDecimal totalPrice;

    private StatusBooking status;

    private List<BookingDetailDTO> bookingdetail;

    public static BookingDTO convertoBookingDTO(Booking booking) {
        return BookingDTO.builder()
                .id(booking.getId())
                .user(UserBookingDTO.convertToUserBookingDTO(booking.getUser()))
                .bookingdate(booking.getBookingdate())
                .totalPrice(booking.getTotalPrice())
                .status(booking.getStatus())
                .bookingdetail(booking.getBookingDetail() == null ? null :
                        booking.getBookingDetail().stream()
                                .map(BookingDetailDTO::convertToBookingDetailDTO)
                                .toList())
                .build();
    }

}
