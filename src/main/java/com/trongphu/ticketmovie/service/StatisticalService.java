package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.model.Booking;
import com.trongphu.ticketmovie.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;

/**
 * Created by Trong Phu on 6/21/2024 00:11:07
 *
 * @author Trong Phu
 */
@Service
public class StatisticalService implements IStatisticalService{



    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public Double getDailyRevenue() {
        LocalDate today = LocalDate.now();
        return bookingRepository.sumTotalPriceByDate(today.atStartOfDay(), today.plusDays(1).atStartOfDay());
    }

    @Override
    public Double getWeeklyRevenue() {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1);
        return bookingRepository.sumTotalPriceByDate(startOfWeek.atStartOfDay(), startOfWeek.plusWeeks(1).atStartOfDay());
    }

    @Override
    public Double getMonthlyRevenue() {
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.withDayOfMonth(1);
        return bookingRepository.sumTotalPriceByDate(startOfMonth.atStartOfDay(), startOfMonth.plusMonths(1).atStartOfDay());
    }

    @Override
    public Double getYearRevenue() {
        LocalDate today = LocalDate.now();
        LocalDate startOfYear = today.withDayOfYear(1);
        return bookingRepository.sumTotalPriceByDate(startOfYear.atStartOfDay(), startOfYear.plusYears(1).atStartOfDay());
    }

    @Override
    public List<Object[]> getTopMoviesByRevenue(int limit) {
        return bookingRepository.findTopMoviesByRevenue(limit);
    }

    @Override
    public List<Object[]> getTopCurrentMoviesByRevenue(int limit) {
        LocalDate today = LocalDate.now();
        return bookingRepository.findTopCurrentMoviesByRevenue(today);
    }

    @Override
    public List<Object[]> getTopMoviesByShowtimeCount(int limit) {
        return bookingRepository.findTopMoviesByShowtimeCount(limit);
    }

    @Override
    public Long getTicketCountByDay() {
        LocalDate today = LocalDate.now();
        return bookingRepository.countTicketsByDate(today.atStartOfDay(), today.plusDays(1).atStartOfDay());
    }

    @Override
    public Long getTicketCountByWeek() {
        LocalDate today = LocalDate.now();
        LocalDate startOfWeek = today.with(WeekFields.of(Locale.getDefault()).dayOfWeek(), 1);
        return bookingRepository.countTicketsByDate(startOfWeek.atStartOfDay(), startOfWeek.plusWeeks(1).atStartOfDay());
    }

    @Override
    public Long getTicketCountByMonth() {
        LocalDate today = LocalDate.now();
        LocalDate startOfMonth = today.withDayOfMonth(1);
        return bookingRepository.countTicketsByDate(startOfMonth.atStartOfDay(), startOfMonth.plusMonths(1).atStartOfDay());
    }

    @Override
    public Long getTicketCountByYear() {
        LocalDate today = LocalDate.now();
        LocalDate startOfYear = today.withDayOfYear(1);
        return bookingRepository.countTicketsByDate(startOfYear.atStartOfDay(), startOfYear.plusYears(1).atStartOfDay());
    }
}
