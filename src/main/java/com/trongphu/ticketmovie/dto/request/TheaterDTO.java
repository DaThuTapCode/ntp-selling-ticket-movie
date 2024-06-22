package com.trongphu.ticketmovie.dto.request;

import com.trongphu.ticketmovie.model.Theater;
import jakarta.validation.constraints.Size;
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

    @Size(min = 1, max = 100, message = "Tên rạp từ 1 - 100 ký tự!")
    private String name;

    @Size(min = 1, max = 100, message = "Vị trí từ 1 - 200 ký tự!")
    private String location;

    private String image;

    @Size(min = 1, max = 13, message = "Số điện thoại nằm trong khoảng từ 1 - 13 ký tự!")
    private String phone;

    @Size(min = 1, max = 200, message = "Email nằm trong khoảng từ 1 - 200 ký tự!")
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
