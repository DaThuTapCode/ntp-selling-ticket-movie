package com.trongphu.ticketmovie.model;

import com.trongphu.ticketmovie.util.StatusBooking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
/**
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    private LocalDate bookingdate;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private StatusBooking status;

}
