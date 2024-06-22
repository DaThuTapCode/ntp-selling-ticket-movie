package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Movie;
import com.trongphu.ticketmovie.model.Screen;
import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 * @author Trong Phu
 */
public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {


    List<ShowTime> findByScreen_Id(Long id);

    List<ShowTime> findByMovie_Id(Long id);

    List<ShowTime> findByScreen_Theater(Theater theater);


    /**
     * Lấy ra suất chiếu phim theo phim và ngày chiếu, giờ chiếu
     */
    @Query("select st from showtimes st where  st.movie.id = :movieId and st.showdate = :dateNow and st.showtime >= :timenow ORDER BY st.showtime asc ")
    List<ShowTime> findAllByMovieId(
            @Param("movieId") Long movieId
            , @Param("dateNow") LocalDate showtdate
            , @Param("timenow") LocalTime showtime
    );

    /**
     * Lấy ra suất chiếu phim theo phim và ngày chiếu, giờ chiếu
     */
    @Query("select st from showtimes st where  st.movie.id = :movieId and st.showdate = :dateNow ORDER BY st.showtime asc ")
    List<ShowTime> findAllByMovieId2(
            @Param("movieId") Long movieId
            , @Param("dateNow") LocalDate showtdate
    );

    /**
     * ADMIN
     */
    @Query("select st from showtimes  st where st.showdate = :showdate and st.screen.id = :screenId and st.screen.theater.id = :theaterId order by st.showtime asc ")
    List<ShowTime> findShowTimeByTheaterAndScreenAndShowdate(
            @Param("theaterId") Long theaterId
            , @Param("screenId") Long screenId
            , @Param("showdate") LocalDate showDate);

}
