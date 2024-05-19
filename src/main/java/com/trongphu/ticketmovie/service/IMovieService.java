package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.MoviesDTO;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.model.Movie;
import com.trongphu.ticketmovie.responsedata.MovieResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IMovieService {

    public Movie crateMovie(MoviesDTO moviesDTO);

    Movie findMovieById(Long id) throws DataNotFoundException;

    Page<Movie> findAllMovies(PageRequest pageRequest);

    Movie updateMovie(Long id,MoviesDTO moviesDTO) throws DataNotFoundException;

    void deleteMovie(Long id);

    boolean existByName(String name);

    /**
     * 1: Enable
     * 2: Disable
     * 3:Waiting*/
    //Khu vực interface dữ liệu trả về client
    Page<MovieResponse> findMoviesByStatusEnable(PageRequest pageRequest);
    Page<MovieResponse> findMoviesByStatusDisable(PageRequest pageRequest);

    /**
     * Lấy ra toàn bộ bản ghi của movies
     * */
    List<MovieResponse> findAllMovies();

    /**
     * Trả về toàn bộ bản ghi của movie trạng thái 1
     * */
    List<MovieResponse> getAllMoviesByStatus1();

    /**
     * Trả về toàn bộ bản ghi của movie trạng thái 2
     * */
    List<MovieResponse> getAllMoviesByStatus2();

    /**
     * Trả về toàn bộ bản ghi của movie trạng thái 3
     * */
    List<MovieResponse> getAllMoviesByStatus3();

    /**
     * Trả về 1 đối tượng movie theo id và status
     * */
    MovieResponse getDetailMovieByIdAndStatus(Long id, Integer status);
}
