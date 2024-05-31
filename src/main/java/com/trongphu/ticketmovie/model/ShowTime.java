package com.trongphu.ticketmovie.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
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

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate showdate;

    private Time showtime;

}
