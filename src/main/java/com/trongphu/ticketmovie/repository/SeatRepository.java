package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Trong Phu
 */
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
