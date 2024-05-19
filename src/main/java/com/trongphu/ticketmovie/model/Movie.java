package com.trongphu.ticketmovie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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

    private Date releasedate;

    private String genre;

    private String language;

    private String performers;

    private String director;

    private String trailer;

    private String image;

    private int status;
}
