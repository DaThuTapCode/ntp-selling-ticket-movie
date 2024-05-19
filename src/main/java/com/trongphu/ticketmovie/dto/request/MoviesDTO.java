package com.trongphu.ticketmovie.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
/**
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoviesDTO {

    @NotBlank(message = "Title is required!")
    @Size(min = 1, max = 300, message = "Title must be between 1 and 300 characters")
    private String title;


    private String descriptions;

    @NotNull(message = "Duration must be not null!")
    @Min(value = 1, message = "Duration must be at least 1!")
    private int duration;

    @NotNull(message = "Release date must be not null!")
    @Future(message = "Release date must be a future date!")
    private Date releasedate ;

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
