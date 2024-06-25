package com.trongphu.ticketmovie.service;

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
}
