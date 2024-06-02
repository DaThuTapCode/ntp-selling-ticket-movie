package com.trongphu.ticketmovie.test;

import com.trongphu.ticketmovie.exception.DataNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Trong Phu on 5/20/2024
 *
 * @author Trong Phu
 */
public class TestPasswordEndcode {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       // if (!passwordEncoder.matches("130904","130904")){
            System.out.println(passwordEncoder.matches("130904","$2a$10$l6aZ9d2htc5zCXq8ay99ruWQTZv9IRRXbOeXXY8d6hMbWE5mumJKm"));
        TimeZone defaultTimeZone = TimeZone.getDefault();
        System.out.println("Default Time Zone: " + defaultTimeZone.getID());
        // Lấy ngày giờ hiện tại
        Date date = new Date();

        // Tạo đối tượng Timestamp từ ngày giờ hiện tại
        Timestamp timestamp = new Timestamp(date.getTime());

        // In ra Timestamp
        System.out.println("Ngày giờ hiện tại: " + timestamp);
        //}
    }
}
