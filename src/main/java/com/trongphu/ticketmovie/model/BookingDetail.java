package com.trongphu.ticketmovie.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
/**
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bookingdetail")
public class BookingDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bookingid")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "showtimeid")
    private ShowTime showtime;

    @ManyToOne
    @JoinColumn(name = "seatid")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "theaterid")
    private Theater theater;

    private BigDecimal price;
}
