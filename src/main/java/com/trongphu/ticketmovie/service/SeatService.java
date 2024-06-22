package com.trongphu.ticketmovie.service;

import com.trongphu.ticketmovie.dto.request.SeatDTO;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.exception.ExistsDataException;
import com.trongphu.ticketmovie.model.Screen;
import com.trongphu.ticketmovie.model.Seat;
import com.trongphu.ticketmovie.repository.SeatRepository;
import com.trongphu.ticketmovie.responsedata.SeatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;

/**
 * @author Trong Phu
 */
@Service
@RequiredArgsConstructor
public class SeatService implements ISeatService {
    private final SeatRepository seatRepository;

    @Override
    public List<SeatResponse> getAll() {
        return seatRepository.findAll().stream().map(SeatResponse::convertToSeatReponse).toList();
    }


    @Override
    public List<SeatResponse> getSeatByScreenId(Long screenid) {
        return seatRepository.findByScreen_Id(screenid).stream().map(SeatResponse::convertToSeatReponse).toList();
    }


    /**
     * ADMIN
     */
    @Override
    public SeatDTO createSeat(SeatDTO seatDTO) throws Exception {
        Seat seat = Seat.builder()
                .seatnumber(seatDTO.getSeatnumber())
                .seatrow(seatDTO.getSeatrow().toUpperCase())
                .type(seatDTO.getType())
                .screen(Screen.builder().id(seatDTO.getScreenid()).build())
                .status(seatDTO.getStatus())
                .build();

        try {
            Integer seatNumber = Integer.parseInt(seat.getSeatnumber());
        } catch (Exception e) {
            throw new Exception("SeatNumber phải là số nguyên!");
        }

        List<SeatDTO> list = seatRepository.findByScreen_Id(seatDTO.getScreenid()).stream()
                .map(SeatDTO::convertToSeatDTO)
                .toList();

        HashMap<String, List<SeatDTO>> listHashMap = new HashMap<>();
        for (SeatDTO seatDTO1 : list) {
            listHashMap.computeIfAbsent(seatDTO1.getSeatrow(), k -> new ArrayList<>()).add(seatDTO1);
        }

        List<SeatDTO> seatRowList = listHashMap.get(seat.getSeatrow());
        if (seatRowList != null) {
            for (SeatDTO existingSeat : seatRowList) {
                if (existingSeat.getSeatnumber().equals(seatDTO.getSeatnumber())) {
                    throw new ExistsDataException("Ghế này đã tồn tại.");
                }
            }
        }
        return SeatDTO.convertToSeatDTO(seatRepository.save(seat));
    }

    @Override
    public Optional<Seat> findById(Long id) {
        return seatRepository.findById(id);
    }

    @Override
    public SeatResponse updateTypeSeat(Long id, String newType) throws Exception {
        List<String> listType = List.of("NULL", "STANDARD", "VIP", "COUPLE");
        boolean checkType = listType.stream().anyMatch(type -> type.equals(newType));
        if (!checkType) {
            throw new Exception("Kiểu ghế không hợp lệ!");
        }

        Seat seat = seatRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Ghế không tồn tại!"));

        seat.setType(newType);
        seatRepository.save(seat);

        SeatResponse seatResponse = SeatResponse.convertToSeatReponse(seat);
        return seatResponse;
    }

    @Override
    public void delete(Long id) throws Exception {
        try {
            Seat seat = seatRepository.findById(id)
                    .orElseThrow(() -> new Exception("Ghế xóa không hợp lệ!"));
            seatRepository.delete(seat);
        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                throw new Exception("Không thể xóa ghế vì đã phát sinh giao dịch");
            } else {
                throw new Exception("Lỗi SQL: " + e.getMessage());
            }
        }
    }

}
