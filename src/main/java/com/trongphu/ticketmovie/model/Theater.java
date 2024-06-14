package com.trongphu.ticketmovie.model;

import com.trongphu.ticketmovie.dto.request.TheaterDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name = "theaters")
@Builder
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;

    private String image;

    private String phone;

    private String email;

    private String description;

    public static Theater convertToTheater(TheaterDTO theaterDTO){
        Theater theater = Theater
                .builder()
                .name(theaterDTO.getName())
                .location(theaterDTO.getLocation())
                .image(theaterDTO.getImage())
                .phone(theaterDTO.getPhone())
                .email(theaterDTO.getEmail())
                .description(theaterDTO.getDescription())
                .build();

        return theater;
    }
}
