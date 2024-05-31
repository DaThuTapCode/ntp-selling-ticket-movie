//package com.trongphu.ticketmovie.responsedata;
//
//import com.trongphu.ticketmovie.model.ShowTime;
//import com.trongphu.ticketmovie.model.Theater;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
///**
// * Created by Trong Phu on 5/27/2024 23:03:59
// *
// * @author Trong Phu
// */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class TheaterResponse {
//    private Long id;
//
//    private String name;
//
//    private String location;
//
//    private String image;
//
//    private String phone;
//
//    private String email;
//
//    private String description;
//
//    private List<ShowTime> showTimes;
//
//
//    public static TheaterResponse convertToTheaterReponse(Theater theater){
//        TheaterResponse theaterResponse = TheaterResponse.builder()
//                .id(theater.getId())
//                .location(theater.getLocation())
//                .image(theater.getImage())
//                /
//                .build();
//
//    }
//}
