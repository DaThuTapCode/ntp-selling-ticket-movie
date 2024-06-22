package com.trongphu.ticketmovie.controller.user;

import com.trongphu.ticketmovie.component.JwtTokenUtil;
import com.trongphu.ticketmovie.dto.request.*;
import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.dto.respone.ResponseError;
import com.trongphu.ticketmovie.model.*;
import com.trongphu.ticketmovie.service.BookingDetailService;
import com.trongphu.ticketmovie.service.BookingService;
import com.trongphu.ticketmovie.service.UserService;
import com.trongphu.ticketmovie.util.StatusBooking;
import com.trongphu.ticketmovie.util.TimeUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Trong Phu on 5/24/2024
 *
 * @author Trong Phu
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/booking")
public class BookingController {

    private final BookingService bookingService;
    private final UserService userService;
    private final BookingDetailService bookingDetailService;
    private final JwtTokenUtil jwtTokenUtil;

    /**
     * API Trả về tất cả các giao dịch đặt vé
     * GET http://localhost:8080/api/v1/booking/all
     */
    @GetMapping("/all")
    public ResponseData getALlBooking() {
        try {
            return new ResponseData(HttpStatus.OK.value(), "Tat ca booking", bookingService.findAll());
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        }
    }


    /**
     * API tạo giao dịch đặt vé
     * GET http://localhost:8080/api/v1/booking/create
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseData> createBooking(
            @Valid @RequestBody BookingDTO bookingDTO
    ) {
        try {
            Optional<User> user = userService.findByUsername(bookingDTO.getUser().getUsername());
            List<BookingDetailDTO> detailDTOList = bookingDTO.getBookingdetail();
            if (user.isEmpty()) {
                return new ResponseEntity<>(new ResponseError(HttpStatus.BAD_REQUEST.value(), "Người dùng không hợp lệ!"), HttpStatus.BAD_REQUEST);
            }
            if (detailDTOList.isEmpty()) {
                return new ResponseEntity<>(new ResponseError(HttpStatus.BAD_REQUEST.value(), "Thông tin hóa đơn không hợp lệ!"), HttpStatus.BAD_REQUEST);
            }
            List<SeatDTO> seatBookedList = bookingService.getBookingByShowtime(bookingDTO.getBookingdetail().get(0).getShowtime().getId()).stream()
                    .flatMap(bookingDTO1 -> bookingDTO1.getBookingdetail().stream())
                    .map(BookingDetailDTO::getSeat).collect(Collectors.toList());

            List<SeatDTO> seatInBooking = bookingDTO.getBookingdetail().stream().map(BookingDetailDTO::getSeat).toList();
//            boolean seatIsValid = seatInBooking.stream().anyMatch(seatDTO -> seatDTO.getId().equals(seatBookedList.stream().map(seatDTO1 -> seatDTO1.getId())));
            for (SeatDTO seatInB : seatInBooking
            ) {
                for (SeatDTO seatIsBd : seatBookedList
                ) {
                    if (seatInB.getId().equals(seatIsBd.getId())) {
                        return new ResponseEntity<>(new ResponseError(HttpStatus.BAD_REQUEST.value(), "Xin lỗi đã có ghế  bị đặt trước đó!"), HttpStatus.BAD_REQUEST);
                    }
                }
            }




            BookingDTO bookingResp = bookingService.save(convertBookingDTOToBooking(bookingDTO, user));
            for (BookingDetailDTO bookingDetailDTO : detailDTOList) {
                bookingDetailService.save(convertBookingDetailDTOToBookingDetail(bookingDetailDTO, bookingResp));
            }
            return new ResponseEntity<>(new ResponseData(HttpStatus.CREATED.value(), "Tạo booking thành công!", bookingResp), HttpStatus.CREATED);
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ResponseEntity<>(new ResponseError(HttpStatus.BAD_REQUEST.value(), "Tạo booking không thành công! " + exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping("payment-result/{id}")
    public ResponseEntity<ResponseData> getPaymentResult(
            @PathVariable Long id
            , HttpServletRequest req
    ){
        final String authHeader = req.getHeader("Authorization");
        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            return new ResponseEntity<>(new ResponseError(HttpStatus.BAD_REQUEST.value(), "Lỗi chưa đăng nhập!"), HttpStatus.BAD_REQUEST);
        }
        final String token = authHeader.substring(7);
        final String username = jwtTokenUtil.extractUserName(token);

        BookingDTO bookingDTORS = bookingService.findByIdBookingAndUserName(id, username);
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Kết quả giao dịch theo id và user name!", bookingDTORS), HttpStatus.OK);
    }


    /**
     * API Trả về tất cả các giao dịch theo khách hàng
     * GET http://localhost:8080/api/v1/booking/all
     */
    @GetMapping("/transaction-history")
    public ResponseData getTransactionHistoryByUserName(
            //@PathVariable("username") String username
            HttpServletRequest req
    ) {
        try {
            final String authHeader = req.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                return new ResponseError(HttpStatus.UNAUTHORIZED.value(), "Lỗi chưa đăng nhập!");
            }
            final String token = authHeader.substring(7);
            final String username = jwtTokenUtil.extractUserName(token);
            List<BookingDTO> list = bookingService.findByUsername(username);
            return new ResponseData(HttpStatus.OK.value(), "Lịch sử giao dịch của khách hàng: " + username, list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Lỗi: " + e.getMessage());
        }
    }

    /**
     * API trả về các seat đã được đặt
     */
    @GetMapping("/showtime-seat-is-booked/{idshowtime}")
    public ResponseData getSeatIsBookedByShowtime(@PathVariable Long idshowtime) {
        try {
            List<SeatDTO> seatBookedList = bookingService.getBookingByShowtime(idshowtime).stream()
                    .flatMap(bookingDTO -> bookingDTO.getBookingdetail().stream())
                    .map(BookingDetailDTO::getSeat)
                    .collect(Collectors.toList());
            return new ResponseData(HttpStatus.OK.value(), "Danh sách seat đã đặt theo showtime", seatBookedList);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Lỗi: " + e.getMessage());
        }
    }

    BookingDetail convertBookingDetailDTOToBookingDetail(BookingDetailDTO bookingDetailDTO, BookingDTO bookingDTO) {
        BookingDetail bookingDetail = BookingDetail
                .builder()
                .booking(Booking.builder().id(bookingDTO.getId()).build())
                .price(bookingDetailDTO.getPrice())
                .seat(Seat.builder()
                        .id(bookingDetailDTO.getSeat().getId())
                        .build())
                .theater(Theater.builder().id(bookingDetailDTO.getTheater().getId()).build())
                .showtime(ShowTime.builder().id(bookingDetailDTO.getShowtime().getId()).build())
                .build();
        return bookingDetail;
    }

    Booking convertBookingDTOToBooking(BookingDTO bookingDTO, Optional<User> user) {
        Booking booking = Booking
                .builder()
                .user(User.builder().id(user.get().getId()).username(user.get().getUsername()).email(user.get().getEmail()).build())
                .bookingdate(TimeUtil.getTimestampNow())
                .totalPrice(bookingDTO.getTotalPrice())
                .orderinfo(bookingDTO.getOrderinfo())
                .transactioncode(bookingDTO.getTransactioncode())
                .status(StatusBooking.PENDING)
                .build();
        return booking;
    }


}
