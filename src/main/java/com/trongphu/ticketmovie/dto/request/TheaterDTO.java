package com.trongphu.ticketmovie.dto.request;

import com.trongphu.ticketmovie.model.Theater;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Trong Phu on 5/25/2024
 *
 * @author Trong Phu
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TheaterDTO {

    private Long id;

    private String name;

    private String location;

    private String image;

    private String phone;

    private String email;

    private String description;

    private MultipartFile file;

    public static TheaterDTO convertToTheaterDTO(Theater theater){
        TheaterDTO theaterDTO = TheaterDTO
                .builder()
                .id(theater.getId())
                .name(theater.getName())
                .location(theater.getLocation())
                .image(theater.getImage())
                .phone(theater.getPhone())
                .email(theater.getEmail())
                .description(theater.getDescription())
                .build();
        return theaterDTO;
    }
}
