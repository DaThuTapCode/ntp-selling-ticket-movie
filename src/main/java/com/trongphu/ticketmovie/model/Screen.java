package com.trongphu.ticketmovie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trongphu.ticketmovie.util.TypeScreenEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "screens")
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "theaterid")
    private Theater theater;

    private String name;

   // @Enumerated(EnumType.STRING)
    private String type;

    @OneToMany(mappedBy = "screen")
    @JsonIgnore
    private List<ShowTime> showTimes;

}
