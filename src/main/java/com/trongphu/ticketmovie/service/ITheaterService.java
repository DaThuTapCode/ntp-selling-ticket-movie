package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.model.Theater;

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

    Theater createTheater(Theater theater);

  //  List<Theater> findByScreens_ShowTimesContaining(ShowTime showTime);

}
