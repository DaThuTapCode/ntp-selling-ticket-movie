package com.trongphu.ticketmovie.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Trong Phu on 5/25/2024
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheaterDTO {
    private String name;

    private String location;

    private String image;

    private String phone;

    private String email;

    private String description;

}
