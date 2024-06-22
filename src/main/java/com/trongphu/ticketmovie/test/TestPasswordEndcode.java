package com.trongphu.ticketmovie.test;

import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.model.Booking;
import com.trongphu.ticketmovie.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Trong Phu on 5/20/2024
 *
 * @author Trong Phu
 */
public class TestPasswordEndcode {
//    @Autowired
//    private BookingService bookingService;
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        if (!passwordEncoder.matches("130904","130904")){
            System.out.println(passwordEncoder.matches("130904","$2a$10$l6aZ9d2htc5zCXq8ay99ruWQTZv9IRRXbOeXXY8d6hMbWE5mumJKm"));
//        }
//        TimeZone defaultTimeZone = TimeZone.getDefault();
//        System.out.println("Default Time Zone: " + defaultTimeZone.getID());
//        // Lấy ngày giờ hiện tại
//        Date date = new Date();
//
//        // Tạo đối tượng Timestamp từ ngày giờ hiện tại
//        Timestamp timestamp = new Timestamp(date.getTime());
//
//        // In ra Timestamp
//        System.out.println("Ngày giờ hiện tại: " + timestamp);
//        //}


//            Timestamp dateBooking = Timestamp.valueOf("2024-06-02 02:09:23");
//        Timestamp expiryTime = Timestamp.valueOf(LocalDateTime.now().minusMinutes(5));
////        System.out.println(expiryTime.after(dateBooking));
//
//        // Chuyển Timestamp thành Calendar
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(dateBooking.getTime());
//
//        // Tăng thời gian lên 5 phút
//        calendar.add(Calendar.MINUTE, 5);
//
//        // Chuyển lại thành Timestamp
//        Timestamp newDateBooking = new Timestamp(calendar.getTimeInMillis());
//
//        // In ra thời gian mới
//        System.out.println("Thời gian mới: " + newDateBooking);


}}
