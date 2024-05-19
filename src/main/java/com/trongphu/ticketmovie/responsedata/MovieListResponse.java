package com.trongphu.ticketmovie.responsedata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 *
 * @author Trong Phu
 */
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class MovieListResponse {
    private List<MovieResponse> movieResponseList;
    private int totalPage;
}
