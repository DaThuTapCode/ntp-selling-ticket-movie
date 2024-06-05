package com.trongphu.ticketmovie.model;

import com.trongphu.ticketmovie.util.TypeSeatEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "seats")
@Builder
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "screenid")
    private Screen screen;

    private String seatrow;

    private String seatnumber;

    //@Enumerated(EnumType.STRING)
    private String type;

    private String status;
}
