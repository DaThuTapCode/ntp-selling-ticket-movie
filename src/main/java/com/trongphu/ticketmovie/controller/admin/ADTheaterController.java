package com.trongphu.ticketmovie.controller.admin;

import com.trongphu.ticketmovie.dto.request.TheaterDTO;
import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.dto.respone.ResponseError;
import com.trongphu.ticketmovie.dto.respone.ResponsePageData;
import com.trongphu.ticketmovie.exception.DataNotFoundException;
import com.trongphu.ticketmovie.model.Theater;
import com.trongphu.ticketmovie.service.TheaterService;
import com.trongphu.ticketmovie.util.FileImageUploadUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Trong Phu on 6/8/2024 13:53:08
 *
 * @author Trong Phu
 */
@RestController
@RequestMapping("${api.prefix}/admin/theaters")
@RequiredArgsConstructor
public class ADTheaterController {

    private final TheaterService theaterService;


    /**
     * API Lấy ra phân trang rạp chiếu
     * GET http://localhost:8080/api/v1/admin/theater/all
     */
    @GetMapping("page")
    private ResponseData getPageTheater(
            @RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Theater> theaterPage = theaterService.findPageTheater(pageable);
        return new ResponsePageData(HttpStatus.OK.value(), "Get all theater", theaterPage.getContent(), theaterPage.getTotalElements());
    }

    /**
     * API Lấy ra tất cả rạp chiếu
     *
     * */
    @GetMapping("all")
    private ResponseEntity<ResponseData> getAllTheater(){
        List<Theater> theaterList = theaterService.getAllTheater();
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Get All Theater", theaterList), HttpStatus.OK);
    }
    /**
     * API lấy theater by id
     *
     * */
    @GetMapping("/{id}")
    private ResponseEntity<ResponseData> getTheaterById(
            @PathVariable Long id
    ) throws DataNotFoundException {
       Optional<Theater> theater = theaterService.getById(id);

       if (theater.isEmpty()){
            throw new DataNotFoundException("Không tìm thấy theater");
       }
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Get theater by id", theater), HttpStatus.OK);
    }

    /**
     * API tạo rạp chiếu mới
     */
    @PostMapping(value = "create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    private ResponseData createTheater(
            @Valid @ModelAttribute TheaterDTO theaterDTO
    ) throws IOException {
        MultipartFile file = theaterDTO.getFile();
        if(file != null && !file.isEmpty()){
            if(file.getSize() > 10 * 1024 * 1024){
                return  new ResponseError(HttpStatus.PAYLOAD_TOO_LARGE.value(), "File lớn hơn 10mb");
            }
            String contentTypeFile = file.getContentType();
            if(contentTypeFile == null || !contentTypeFile.startsWith("image/")) {
                return new ResponseError(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), "File ảnh không hợp lệ!");
            }
        }
        String filename = FileImageUploadUtil.storeFile(file);
        theaterDTO.setImage(filename);
        TheaterDTO theaterDTO1 =  TheaterDTO.convertToTheaterDTO(theaterService.createTheater(theaterDTO));
        return  new ResponseData(HttpStatus.CREATED.value(), "Tạo thành công rạp mới!", theaterDTO1);
    }

    @PutMapping(value = "update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    private ResponseData updateTheater(
            @PathVariable Long id,
            @Valid @ModelAttribute TheaterDTO theaterDTO
    ) throws Exception {
        MultipartFile file = theaterDTO.getFile();
        if(file != null && !file.isEmpty()){
            if(file.getSize() > 10 * 1024 * 1024){
                return  new ResponseError(HttpStatus.PAYLOAD_TOO_LARGE.value(), "File lớn hơn 10mb");
            }
            String contentTypeFile = file.getContentType();
            if(contentTypeFile == null || !contentTypeFile.startsWith("image/")) {
                return new ResponseError(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), "File ảnh không hợp lệ!");
            }
            String filename = FileImageUploadUtil.storeFile(file);
            theaterDTO.setImage(filename);
            TheaterDTO theaterDTO1 =  TheaterDTO.convertToTheaterDTO(theaterService.updateTheater(id,theaterDTO));
            return  new ResponseData(HttpStatus.CREATED.value(), "Update rạp thành công!", theaterDTO1);
        }

        TheaterDTO theaterDTO1 =  TheaterDTO.convertToTheaterDTO(theaterService.updateTheater(id,theaterDTO));
        return  new ResponseData(HttpStatus.CREATED.value(), "Update rạp thành công!", theaterDTO1);

    }


}
