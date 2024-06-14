package com.trongphu.ticketmovie.sercurity;

import com.trongphu.ticketmovie.filters.JwtTokenFilter;
import com.trongphu.ticketmovie.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * Created by Trong Phu on 5/21/2024
 *
 * @author Trong Phu
 */
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
public class WebConfigSecurity {
    @Value("${api.prefix}")
    private String apiPrefix;

    private final JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
//                .csrf().disable()
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(request -> {
                    request
                            //Cho phép mọi request được đi qua
                            .requestMatchers(
                                    String.format("%s/users/register", apiPrefix)
                                    , String.format("%s/users/login", apiPrefix)
                                    , String.format("%s/movies/**", apiPrefix)
                                    , String.format("%s/images/**", apiPrefix)
                                    , String.format("%s/theaters/**", apiPrefix)
                                    , String.format("%s/payment/create-payment", apiPrefix)
                                    , String.format("%s/payment/payment-callback**", apiPrefix)
                                    , "/sendEmail"
//                                    , String.format("%s/theaters/", apiPrefix)
                            )
                            .permitAll()

                            //Phải đăng nhập mới được dùng
                            .requestMatchers(HttpMethod.GET,
                                    String.format("%s/users/hihi", apiPrefix)
                                    , String.format("%s/seat/**", apiPrefix)
                                    , String.format("%s/showtime/**", apiPrefix)
                                    , String.format("%s/booking/**", apiPrefix)
                            ).hasAnyRole(Role.ADMIN, Role.USER, Role.MODERATOR)
                            //Chỉ ADMIN và MODERATOR
                            .requestMatchers(HttpMethod.GET,
                                    String.format("%s/admin**", apiPrefix)
                            ).hasAnyRole(Role.ADMIN, Role.MODERATOR)
                            .requestMatchers(HttpMethod.POST
                            , String.format("%s/theaters/add", apiPrefix)
                            , String.format("%s/admin/movies**", apiPrefix)
                            , String.format("%s/admin/showtimes/create", apiPrefix)
                    ).hasAnyRole(Role.ADMIN, Role.MODERATOR)
                            .anyRequest()
                            .authenticated();
                });
        return http.build();
    }
}
