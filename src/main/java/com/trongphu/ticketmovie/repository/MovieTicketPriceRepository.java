package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.MovieTicketPrice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieTicketPriceRepository extends JpaRepository<MovieTicketPrice, Long> {
}
