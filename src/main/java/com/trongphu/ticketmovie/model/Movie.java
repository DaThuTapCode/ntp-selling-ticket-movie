package com.trongphu.ticketmovie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Trong Phu
 */
@Entity(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String descriptions;

    private int duration;

    private LocalDate releasedate;

    private String genre;

    private String language;

    private String performers;

    private String director;

    private String trailer;

    private String image;

    private int status;

    @OneToMany(mappedBy = "movie")
    @JsonIgnore
    private List<ShowTime> showtimes;
}
