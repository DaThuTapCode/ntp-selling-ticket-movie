package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Booking;
import com.trongphu.ticketmovie.model.User;
import com.trongphu.ticketmovie.util.StatusBooking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Trong Phu
 */
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    boolean existsByUser(User u);
    //Phan trang

    @Override
    Page<Booking> findAll(Pageable pageable);

    List<Booking> findByUser_UsernameAndAndStatusOrderByBookingdateDesc(String username, StatusBooking statusBooking);

    @Query("""
            select bk from booking bk 
            join bk.bookingDetail bkd 
            where bkd.showtime.id = :idshowtime and  bk.status = 'CONFIRMED' or bk.status = 'PENDING'
            """)
    List<Booking> SeatIsBookedByShowTime(@Param("idshowtime") Long idshowtime);

    List<Booking> findBookingByStatus(StatusBooking statusBooking);

    @Query("select bk from booking bk where bk.id = :id and bk.user.username = :username and bk.status like 'CONFIRMED'")
    Booking findBookingByIđAnUserr(
            @Param("id") Long id
            , @Param("username") String username
    );



    /**
     * Thong ke theo rap*/

    /**
     * Thong ke tong tien theo rap, ngay bat dau, ngay ket thuc
     * */
    @Query("SELECT SUM(bkd.price) FROM booking b join bookingdetail bkd on bkd.booking.id = b.id where b.status = 'CONFIRMED' and b.bookingdate between :startDate AND :endDate AND bkd.theater.id = :theaterId")
    Double sumTotalPriceByDateAndTheater(LocalDateTime startDate, LocalDateTime endDate, Long theaterId);



    /**
     * Thong ke toan bo
     * */

    /**
     * Thonng ke tong tien cua cac hoa don thanh toan thanh cong theo ngay bat dau va ngay ket thuc
     * */
    @Query("SELECT SUM(b.totalPrice) FROM booking b WHERE  b.status = 'CONFIRMED' AND b.bookingdate BETWEEN :startDate AND :endDate")
    Double sumTotalPriceByDate(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT COUNT(bd.id) FROM bookingdetail bd WHERE bd.booking.bookingdate BETWEEN :startDate AND :endDate")
    Long countTicketsByDate(LocalDateTime startDate, LocalDateTime endDate);

    @Query("SELECT m.title, SUM(b.totalPrice) AS revenue FROM booking b JOIN b.bookingDetail bd JOIN bd.showtime s JOIN s.movie m GROUP BY m.title ORDER BY revenue DESC")
    List<Object[]> findTopMoviesByRevenue(int limit);

    @Query("SELECT m.title, SUM(b.totalPrice) AS revenue FROM booking b JOIN b.bookingDetail bd JOIN bd.showtime s JOIN s.movie m WHERE s.showdate > :currentDate GROUP BY m.title ORDER BY revenue DESC")
    List<Object[]> findTopCurrentMoviesByRevenue(@Param("currentDate") LocalDate currentDate);


    @Query("SELECT m.title, COUNT(s.id) AS showtimeCount FROM bookingdetail bd JOIN bd.showtime s JOIN s.movie m GROUP BY m.title ORDER BY showtimeCount DESC")
    List<Object[]> findTopMoviesByShowtimeCount(int limit);
}
