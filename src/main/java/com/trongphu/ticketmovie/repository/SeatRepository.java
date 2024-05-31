package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByScreen_Id(Long id);
}
