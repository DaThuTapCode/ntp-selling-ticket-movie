package com.trongphu.ticketmovie.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
/**
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "showtimes")
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movieid")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "screenid")
    private Screen screen;

    private Date showdate;

    private Time showtime;

}
