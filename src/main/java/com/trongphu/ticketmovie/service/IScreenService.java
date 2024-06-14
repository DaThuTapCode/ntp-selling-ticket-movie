package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.model.Screen;
import com.trongphu.ticketmovie.model.Theater;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
public interface IScreenService {

    List<Screen> getScreensByTheater(Theater theater);
}
