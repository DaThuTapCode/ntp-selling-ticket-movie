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
@Entity(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movieid")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "theaterid")
    private Theater theater;

    private String name;

    private String descriptions;

    private String image;

    private Date eventdate;

    private String location;

}
