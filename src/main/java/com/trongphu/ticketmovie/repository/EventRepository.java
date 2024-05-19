package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Trong Phu
 */
public interface EventRepository extends JpaRepository<Event, Long> {
}
