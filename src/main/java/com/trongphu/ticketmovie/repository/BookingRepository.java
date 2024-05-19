package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Booking;
import com.trongphu.ticketmovie.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Trong Phu
 */
public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsByUser(User u);
    //Phan trang

    @Override
    Page<Booking> findAll(Pageable pageable);
}
