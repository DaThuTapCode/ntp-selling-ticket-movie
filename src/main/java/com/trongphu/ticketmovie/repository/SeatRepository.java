package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Query("select s from seats s where s.status like 'available' and s.screen.id = :id order by s.seatrow asc, s.seatnumber asc")
    List<Seat> findByScreen_Id(Long id);
}
