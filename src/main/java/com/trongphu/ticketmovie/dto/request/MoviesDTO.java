package com.trongphu.ticketmovie.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Date;
/**
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesDTO {

    @NotBlank(message = "Tên phim là bắt buộc!")
    @Size(min = 1, max = 300, message = "Tên phim từ 1 đến 300 ký tự!")
    private String title;


    private String descriptions;

    @NotNull(message = "Thời lượng phim không được null!")
    @Min(value = 1, message = "Thời lượng phim phải lớn hơn 1!")
    @Max(value = Integer.MAX_VALUE, message = "Thời lượng phim phải nhỏ hơn " + Integer.MAX_VALUE)
    private int duration;

    @NotNull(message = "Ngày phát hành không được null!")
    @Future(message = "Ngày phát hành phải lớn hơn ngày hôm nay!")
   // @DateTimeFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate releasedate ;

    @NotNull(message = "Genre must be not null!")
    @Size(min = 1, max = 100, message = "Genre must be between 1 and 100 characters!")
    private String genre;


    @Size(min = 1, max = 100, message = "Genre must be between 1 and 100 characters!")
    private String language;


    private String performers;

    @Size(min = 1, max = 200, message = "Director must be 1 and 200 characters!")
    private String director;


    private String trailer;

    private String image;

    private int status;

    private MultipartFile file;
}
