package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
public interface TheaterRepository extends JpaRepository<Theater, Long> {
//    List<Theater> findByScreens_ShowTimesContaining(ShowTime showTime);
}
