package com.trongphu.ticketmovie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trongphu.ticketmovie.util.StatusBooking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

    private Timestamp bookingdate;

    private String transactioncode;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private StatusBooking status;

    private  String orderinfo;
    @OneToMany(mappedBy = "booking", fetch = FetchType.EAGER)
//    @JsonIgnore
    private List<BookingDetail> bookingDetail;
}
