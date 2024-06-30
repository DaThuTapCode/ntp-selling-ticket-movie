package com.trongphu.ticketmovie.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Created by Trong Phu on 27/06/2024 14:18:18
 *
 * @author Trong Phu
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieStatistical {
    private Long id;
    private String title;
    private String image;
    private BigDecimal revenue;
    private Long totalshowtime;


}
