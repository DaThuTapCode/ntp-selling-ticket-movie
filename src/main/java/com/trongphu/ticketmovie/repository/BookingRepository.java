package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Booking;
import com.trongphu.ticketmovie.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsByUser(User u);
    //Phan trang

    @Override
    Page<Booking> findAll(Pageable pageable);

    @Query("select count(bk) > 0 from booking bk where  bk.id = :id and bk.status = :status")
    boolean checkStatusAndExists(
           @Param("id") Long id
           , @Param("status") String status
    );

    List<Booking> findByUser_Username(String username);
}
