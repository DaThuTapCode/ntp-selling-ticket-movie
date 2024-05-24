package com.trongphu.ticketmovie.test;

import com.trongphu.ticketmovie.exception.DataNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
        //}
    }
}
