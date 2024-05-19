package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {
}
