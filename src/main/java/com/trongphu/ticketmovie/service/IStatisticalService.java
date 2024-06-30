package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.BookingDTO;
import com.trongphu.ticketmovie.dto.request.MovieStatistical;
import com.trongphu.ticketmovie.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Trong Phu on 6/21/2024 00:10:40
 *
 * @author Trong Phu
 */
public interface IStatisticalService {
    Double getDailyRevenue(LocalDate date);
    Double getWeeklyRevenue();
    Double getMonthlyRevenue();
    Double getYearRevenue();



    Double getDailyRevenueTheater(LocalDate date, Long theaterId);
    Double getMonthlyRevenueTheater(LocalDate date, Long theaterId);
    Double getYearlyRevenueTheater(LocalDate date, Long theaterId);

    List<Object[]> getTopMoviesByRevenue(int limit);
    List<Object[]> getTopCurrentMoviesByRevenue(int limit);
    List<Object[]> getTopMoviesByShowtimeCount(int limit);
    Long getTicketCountByDay();
    Long getTicketCountByWeek();
    Long getTicketCountByMonth();
    Long getTicketCountByYear();

    Long getCountShowtimeByMovieId(Long movieid);

    Page<Booking> getBookingByTheaterId(Pageable pageable, Long theaterid);
    Page<Object[]> getListRevenueMovie(Pageable pageable, String  title);
}
