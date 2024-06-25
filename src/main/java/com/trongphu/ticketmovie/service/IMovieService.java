package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.MoviesDTO;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.model.Movie;
import com.trongphu.ticketmovie.responsedata.MovieResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
/**
 *
 * @author Trong Phu
 */
public interface IMovieService {

    public Movie crateMovie(MoviesDTO moviesDTO);

    Movie findMovieById(Long id) throws DataNotFoundException;

    Page<Movie> findPageAllMovies(Pageable pageable);

    Movie updateMovie(Long id,MoviesDTO moviesDTO) throws DataNotFoundException;

    void deleteMovie(Long id);

    boolean existByName(String name);

    /**
     * 1: Enable
     * 2: Disable
     * 3:Waiting*/
    Page<MovieResponse> findMoviesByStatusEnable(PageRequest pageRequest);
    Page<MovieResponse> findMoviesByStatusDisable(PageRequest pageRequest);

    /**
     * Lấy ra toàn bộ bản ghi của movies
     * */
    List<MovieResponse> findAllMovies();

    /**
     * Trả về toàn bộ bản ghi của movie trạng thái 1
     * */
    List<MovieResponse> getAllMoviesIsShowing(LocalDate currentdate, LocalTime currenttime, Integer status);

    /**
     * Trả về toàn bộ bản ghi của movie trạng thái 2
     * */
    List<MovieResponse> getAllMoviesByStatus2();

    List<MovieResponse> getAllMovieByStatus();
    /**
     * Trả về danh sách của movie sắp chiếu
     * */
    List<MovieResponse> getAllMovieUpcoming(LocalDate currentdate, Integer status);

    /**
     * Trả về 1 đối tượng movie theo id và status
     * */
    MovieResponse getDetailMovieByIdAndStatus(Long id, Integer status);

    List<MovieResponse> getMovieSellTicketInAdvance(LocalDate currentdate);
}
