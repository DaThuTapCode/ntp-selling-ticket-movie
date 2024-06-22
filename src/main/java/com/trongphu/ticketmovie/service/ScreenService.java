package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.model.Screen;
import com.trongphu.ticketmovie.model.Theater;
import com.trongphu.ticketmovie.repository.ScreenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
@Service
@RequiredArgsConstructor
public class ScreenService implements IScreenService{
    private final ScreenRepository screenRepository;

    @Override
    public List<Screen> getScreensByTheater(Theater theater) {
        return screenRepository.findByTheater(theater);
    }

    @Override
    public Screen create(Screen screen) {
        screen.setId(null);
        return screenRepository.save(screen);
    }

}
