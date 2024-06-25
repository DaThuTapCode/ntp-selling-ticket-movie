package com.trongphu.ticketmovie.controller.admin;

import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.service.BookingDetailService;
import com.trongphu.ticketmovie.service.BookingService;
import com.trongphu.ticketmovie.service.IStatisticalService;
import com.trongphu.ticketmovie.service.StatisticalService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Trong Phu on 6/8/2024 13:54:19
 *
 * @author Trong Phu
 */
@RestController
@RequestMapping("${api.prefix}/admin/statistical")
@RequiredArgsConstructor
public class ADStatisticalController {

    private final BookingService bookingService;

    private final BookingDetailService bookingDetailService;

    @Autowired
    private IStatisticalService statisticalService;

    @GetMapping("/daily-revenue/{date}")
    public ResponseEntity<ResponseData> getDailyRevenue(
            @PathVariable LocalDate date,
            @RequestParam(required = false) Long theaterId
    ) {
        if (theaterId != null) {
            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Doanh thu ngày của rạp", statisticalService.getDailyRevenueTheater(date, theaterId)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Doanh thu ngày", statisticalService.getDailyRevenue(date)), HttpStatus.OK);
    }

//    @GetMapping("/weekly-revenue")
//    public ResponseEntity<ResponseData> getWeeklyRevenue(
//            @RequestParam(required = false) Long theaterId
//    ) {
//        if(theaterId != null){
//            LocalDate date = LocalDate.now();
//            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Doanh thu tuần của rạp", statisticalService.getMonthlyRevenueTheater(date, theaterId)), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Doanh thu tuần", statisticalService.getWeeklyRevenue()), HttpStatus.OK);
//    }

    @GetMapping("/monthly-revenue")
    public ResponseEntity<ResponseData> getMonthlyRevenue(
            @RequestParam(required = false) Long theaterId
    ) {
        if (theaterId != null) {
            LocalDate date = LocalDate.now();
            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Doanh thu tháng của rạp", statisticalService.getMonthlyRevenueTheater(date, theaterId)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Doanh thu tháng", statisticalService.getMonthlyRevenue()), HttpStatus.OK);
    }

    @GetMapping("/yearly-revenue")
    public ResponseEntity<ResponseData> getYearRevenue(
            @RequestParam(required = false) Long theaterId
    ) {
        if (theaterId != null) {
            LocalDate date = LocalDate.now();
            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Doanh thu năm", statisticalService.getYearlyRevenueTheater(date, theaterId)), HttpStatus.OK);

        }
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Doanh thu năm", statisticalService.getYearRevenue()), HttpStatus.OK);
    }

    @GetMapping("/top-movies-by-revenue")
    public ResponseEntity<ResponseData> getTopMoviesByRevenue(
            @RequestParam int limit
    ) {
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Lấy top " + limit + " phim có doanh thu cao", statisticalService.getTopMoviesByRevenue(limit)), HttpStatus.OK);
    }

    @GetMapping("/top-current-movies-by-revenue")
    public ResponseEntity<ResponseData> getTopCurrentMoviesByRevenue(
            @RequestParam int limit
    ) {
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Lấy top phim có doanh thu cao theo ngày", statisticalService.getTopCurrentMoviesByRevenue(limit)), HttpStatus.OK);

    }

    @GetMapping("/top-movies-by-showtime-count")
    public ResponseEntity<ResponseData> getTopMoviesByShowtimeCount(
            @RequestParam int limit
    ) {
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Lấy top " + limit + " phim có doanh thu cao", statisticalService.getTopMoviesByShowtimeCount(limit)), HttpStatus.OK);
    }

    @GetMapping("/ticket-count-by-day")
    public ResponseEntity<ResponseData> getTicketCountByDay() {
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Lấy số vé bán ra theo tuần", statisticalService.getTicketCountByDay()), HttpStatus.OK);
    }

    @GetMapping("/ticket-count-by-week")
    public ResponseEntity<ResponseData> getTicketCountByWeek() {
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Lấy top  phim có doanh thu cao", statisticalService.getTicketCountByWeek()), HttpStatus.OK);
    }

    @GetMapping("/ticket-count-by-month")
    public ResponseEntity<ResponseData> getTicketCountByMonth() {
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Lấy top phim có doanh thu cao", statisticalService.getTicketCountByMonth()), HttpStatus.OK);
    }

    @GetMapping("/ticket-count-by-year")
    public ResponseEntity<ResponseData> getTicketCountByYear() {
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Lấy top phim có doanh thu cao", statisticalService.getTicketCountByYear()), HttpStatus.OK);
    }

}
