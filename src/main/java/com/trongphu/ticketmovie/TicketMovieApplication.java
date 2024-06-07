package com.trongphu.ticketmovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TicketMovieApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketMovieApplication.class, args);
    }

}
