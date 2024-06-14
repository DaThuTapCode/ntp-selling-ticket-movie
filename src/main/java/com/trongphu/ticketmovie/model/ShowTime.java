package com.trongphu.ticketmovie.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
/**
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "showtimes")
@Builder
public class ShowTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Phim không được để null!")
    @ManyToOne
    @JoinColumn(name = "movieid")
    private Movie movie;

    @NotNull(message = "Phòng chiếu không được để null!")
    @ManyToOne
    @JoinColumn(name = "screenid")
    private Screen screen;

    @NotNull(message = "Ngày chiếu không được null!")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate showdate;

    @NotNull(message = "Giờ chiếu không được null!")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime showtime;

}
