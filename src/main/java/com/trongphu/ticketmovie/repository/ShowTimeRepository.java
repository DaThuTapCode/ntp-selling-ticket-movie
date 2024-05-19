package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Trong Phu
 */
public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {
}
