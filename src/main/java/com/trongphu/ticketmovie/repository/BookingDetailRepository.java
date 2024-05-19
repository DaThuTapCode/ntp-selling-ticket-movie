package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Trong Phu
 */
public interface BookingDetailRepository extends JpaRepository<BookingDetail, Long> {
}
