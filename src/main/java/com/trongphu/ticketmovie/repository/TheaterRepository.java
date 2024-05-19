package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Trong Phu
 */
public interface TheaterRepository extends JpaRepository<Theater, Long> {
}
