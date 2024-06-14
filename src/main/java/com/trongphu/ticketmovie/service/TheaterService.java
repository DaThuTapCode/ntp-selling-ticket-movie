package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.TheaterDTO;
import com.trongphu.ticketmovie.model.ShowTime;
import com.trongphu.ticketmovie.model.Theater;
import com.trongphu.ticketmovie.repository.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Trong Phu
 */
@Service
public class TheaterService implements ITheaterService {

    @Autowired
    private TheaterRepository repository;

    @Override
    public List<Theater> getAllTheater() {
        return repository.findAll();
    }

    @Override
    public Optional<Theater> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Theater createTheater(TheaterDTO theaterDTO) {
        return repository.save(Theater.convertToTheater(theaterDTO));
    }

    /**
     * ADMIN
     * */
    @Override
    public Page<Theater> findPageTheater(Pageable pageable) {
        return repository.findAll(pageable);
    }

//    @Override
//    public List<Theater> findByScreens_ShowTimesContaining(ShowTime showTime) {
//        return repository.findByScreens_ShowTimesContaining(showTime);
//    }
}
