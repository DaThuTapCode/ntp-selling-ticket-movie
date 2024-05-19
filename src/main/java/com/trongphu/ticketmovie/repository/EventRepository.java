package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
