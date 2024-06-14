package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Screen;
import com.trongphu.ticketmovie.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
public interface ScreenRepository extends JpaRepository<Screen, Long> {
    List<Screen> findByTheater(Theater theater);
}
