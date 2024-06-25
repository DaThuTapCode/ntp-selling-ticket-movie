package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.TheaterDTO;
import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.model.Theater;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Trong Phu
 */
@Repository
public interface ITheaterService {
    List<Theater> getAllTheater();

    Optional<Theater> getById(Long id);


    Theater createTheater(TheaterDTO theaterDTO);

    Theater updateTheater(Long id, TheaterDTO theaterDTO) throws Exception;
    /**
     * ADMIN
     */

    Page<Theater> findPageTheater(Pageable pageable);


    //  List<Theater> findByScreens_ShowTimesContaining(ShowTime showTime);

}
