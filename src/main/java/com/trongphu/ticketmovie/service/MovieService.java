package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.MoviesDTO;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.model.Movie;
import com.trongphu.ticketmovie.repository.MovieRepository;
import com.trongphu.ticketmovie.responsedata.MovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
/**
 *
 * @author Trong Phu
 */
public class MovieService implements IMovieService {
    private final MovieRepository movieRepository;

    @Override
    public Movie crateMovie(MoviesDTO moviesDTO) {
        Movie newMovie = Movie.builder()
                .title(moviesDTO.getTitle())
                .descriptions(moviesDTO.getDescriptions())
                .duration(moviesDTO.getDuration())
                .releasedate(moviesDTO.getReleasedate())
                .genre(moviesDTO.getGenre())
                .language(moviesDTO.getLanguage())
                .performers(moviesDTO.getPerformers())
                .director(moviesDTO.getDirector())
                .trailer(moviesDTO.getTrailer())
                .image(moviesDTO.getImage())
                .status(moviesDTO.getStatus())
                .build();

        return movieRepository.save(newMovie);
    }

    @Override
    public Movie findMovieById(Long id) throws DataNotFoundException {
        return movieRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Cannot find product witd id =" + id));
    }

    @Override
    public Page<Movie> findAllMovies(PageRequest pageRequest) {
        return movieRepository.findAll(pageRequest);
    }

    @Override
    public Movie updateMovie(Long id, MoviesDTO moviesDTO) throws DataNotFoundException {
        Movie existsingMovie = findMovieById(id);
        if(existsingMovie != null){
            existsingMovie.setTitle(moviesDTO.getTitle());
            existsingMovie.setDescriptions(moviesDTO.getDescriptions());
            existsingMovie.setDirector(moviesDTO.getDirector());
            existsingMovie.setDuration(moviesDTO.getDuration());
            existsingMovie.setGenre(moviesDTO.getGenre());
            existsingMovie.setReleasedate(moviesDTO.getReleasedate());
            existsingMovie.setLanguage(moviesDTO.getLanguage());
            existsingMovie.setPerformers(moviesDTO.getPerformers());
            existsingMovie.setTrailer(moviesDTO.getTrailer());
            existsingMovie.setStatus(moviesDTO.getStatus());
            existsingMovie.setImage(moviesDTO.getImage());
            return movieRepository.save(existsingMovie);
        }
        return null;
    }

    @Override
    public void deleteMovie(Long id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        optionalMovie.ifPresent(movieRepository::delete);
    }

    @Override
    public boolean existByName(String title) {
        return movieRepository.existsByTitle(title);
    }

    @Override
    public Page<MovieResponse> findMoviesByStatusEnable(PageRequest pageRequest) {
        return movieRepository.findByStatus(1, pageRequest).map(MovieResponse::convertToMovie);
    }

    @Override
    public Page<MovieResponse> findMoviesByStatusDisable(PageRequest pageRequest) {
        return movieRepository.findByStatus(0, pageRequest).map(MovieResponse::convertToMovie);
    }

    @Override
    public List<MovieResponse> findAllMovies() {
        return movieRepository.findAll().stream()
                .map(MovieResponse::convertToMovie).toList();
    }

    @Override
    public List<MovieResponse> getAllMoviesByStatus1() {
        return movieRepository.findByStatus(1).stream().map(MovieResponse::convertToMovie).toList();
    }

    @Override
    public List<MovieResponse> getAllMoviesByStatus2() {
        return movieRepository.findByStatus(2).stream().map(MovieResponse::convertToMovie).toList();
    }

    @Override
    public List<MovieResponse> getAllMoviesByStatus3() {
        return movieRepository.findByStatus(3).stream().map(MovieResponse::convertToMovie).toList();
    }

    @Override
    public MovieResponse getDetailMovieByIdAndStatus(Long id, Integer status) {
        Movie movieDetail = movieRepository.findByIdAndStatus(id, status);
        if(movieDetail != null){
            return MovieResponse.convertToMovie(movieRepository.findByIdAndStatus(id, status));
        }
        return null;

    }


    //Dữ liệu trả về cho client



}
