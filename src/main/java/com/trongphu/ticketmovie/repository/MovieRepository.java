package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Trong Phu
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {
    boolean existsByTitle(String title);

    Page<Movie> findAll(Pageable pageable); // phan trang

    Page<Movie> findByStatus(Integer status, Pageable pageable);

    List<Movie> findByStatus(Integer status);

    Movie findByIdAndStatus(Long id, Integer status);


    /**
     * Lay ra phim sap chieu theo cac tieu chi
     * - Ngay phat hanh > ngay hien tai
     * - Khong co suat chieu som nao
     * */
    @Query("select mvs from  movies mvs left  join mvs.showtimes st where mvs.releasedate > :currentdate and mvs.status = :status and st.movie is null ")
    List<Movie> getMovieUpComing(
            @Param("currentdate") LocalDate currentdate
            ,@Param("status") Integer status
            );

    /**
     * Lay ra phim dang chieu theo cac tieu chi
     * - Ngay phat hanh <= ngay hien tai
     * - Co suat chieu
     *
     * */
    @Query("select  mvs from  movies mvs  join mvs.showtimes st where  mvs.releasedate < :currentdate and mvs.status = :status and st.showdate >= :currentdate and st.showtime >= :currenttime")
    List<Movie> getMovieIsShowing(
            @Param("currentdate") LocalDate currentdate
            , @Param("currenttime")LocalTime localTime
            , @Param("status") Integer status
    );


}
