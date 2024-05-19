package com.trongphu.ticketmovie.model;

import com.trongphu.ticketmovie.util.TypeScreenEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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

    private Integer capacity;

    @Enumerated(EnumType.STRING)
    private TypeScreenEnum type;

}
