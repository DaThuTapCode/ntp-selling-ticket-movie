//package com.trongphu.ticketmovie.sercurity;
//
//import com.trongphu.ticketmovie.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
///**
// *
// * @author Trong Phu
// */
//@Configuration
//@RequiredArgsConstructor
//public class ConfigSecurity {
//    private final UserRepository userRepository;
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> {
//            User existingUser =
//                userRepository.findByUsername(username)
//
//        }
//
//    }
//}
