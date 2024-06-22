package com.trongphu.ticketmovie.service;

import java.util.List;

/**
 * Created by Trong Phu on 6/21/2024 00:10:40
 *
 * @author Trong Phu
 */
public interface IStatisticalService {
    Double getDailyRevenue();
    Double getWeeklyRevenue();
    Double getMonthlyRevenue();
    Double getYearRevenue();
    List<Object[]> getTopMoviesByRevenue(int limit);
    List<Object[]> getTopCurrentMoviesByRevenue(int limit);
    List<Object[]> getTopMoviesByShowtimeCount(int limit);
    Long getTicketCountByDay();
    Long getTicketCountByWeek();
    Long getTicketCountByMonth();
    Long getTicketCountByYear();
}
