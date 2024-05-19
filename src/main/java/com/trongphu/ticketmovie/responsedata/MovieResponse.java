package com.trongphu.ticketmovie.responsedata;

import com.trongphu.ticketmovie.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 *
 * @author Trong Phu
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MovieResponse {

    private Long id;

    private String title;

    private String descriptions;

    private int duration;

    private Date releasedate ;

    private String genre;

    private String language;

    private String performers;

    private String director;

    private String trailer;

    private String image;

    private int status;

    public static MovieResponse convertToMovie(Movie movie){
        MovieResponse movieResponse = MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .descriptions(movie.getDescriptions())
                .duration(movie.getDuration())
                .releasedate(movie.getReleasedate())
                .genre(movie.getGenre())
                .language(movie.getLanguage())
                .performers(movie.getPerformers())
                .director(movie.getDirector())
                .trailer(movie.getTrailer())
                .image(movie.getImage())
                .status(movie.getStatus())
                .build();
        return movieResponse;
    }

}
