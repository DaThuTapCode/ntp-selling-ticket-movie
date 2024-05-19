package com.trongphu.ticketmovie.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "promotions")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movieid")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theaterid")
    private Theater theater;

    private String title;

    private String image;

    private String description;

    private Date startdate;

    private Date enddate;
}
