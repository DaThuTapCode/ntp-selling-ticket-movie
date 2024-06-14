package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Movie;
import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.model.Theater;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
public interface TheaterRepository extends JpaRepository<Theater, Long> {
//    List<Theater> findByScreens_ShowTimesContaining(ShowTime showTime);


    /**
     * ADMIN
     * */


    Page<Theater> findAll(Pageable pageable); // phan trang


}
