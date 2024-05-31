package com.trongphu.ticketmovie.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalTime;

/**
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "movieticketprices")
public class MovieTicketPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movieid")
    private Movie movie;

    private BigDecimal price;

    private Integer dayofweek;

    private LocalTime startime;

    private LocalTime endtime;
}
