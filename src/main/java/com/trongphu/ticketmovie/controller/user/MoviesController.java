package com.trongphu.ticketmovie.controller.user;

import com.trongphu.ticketmovie.dto.request.MoviesDTO;
import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.dto.respone.ResponseError;
import com.trongphu.ticketmovie.responsedata.MovieListResponse;
import com.trongphu.ticketmovie.responsedata.MovieResponse;
import com.trongphu.ticketmovie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * @author Trong Phu
 */
@RestController
@RequestMapping("${api.prefix}/movies")
@RequiredArgsConstructor //Tự động injection dependencies cho các biến final
public class MoviesController {

    private final MovieService movieService;

    /**
     * API trả về ảnh theo tên ảnh
     * GET http://localhost:8080/api/v1/movies/images/{{imageName}}
     */
    @GetMapping("images/{imageName}")
    public ResponseEntity<?> viewImage(@PathVariable String imageName) {
        try {
            java.nio.file.Path imagePath = Paths.get("uploads/" + imageName);
            UrlResource resource = new UrlResource(imagePath.toUri());
            if (resource.exists()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.IMAGE_JPEG)
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Trả về danh sách phim đang chiếu và sắp chiếu ở trạng thái 1
    @GetMapping("")
    public ResponseEntity<?> getMoviesEnable(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ) {
        //Tạo pageable từ thông tin trang và giới hạn
        PageRequest pageRequest = PageRequest.of(
                page, limit, Sort.by("title").descending()
        );
        Page<MovieResponse> moviePage = movieService.findMoviesByStatusEnable(pageRequest);
        int totalPage = moviePage.getTotalPages();
        List<MovieResponse> movieListResponses = moviePage.getContent();

        ResponseData responseData = new ResponseData<>(HttpStatus.OK.value(), "", MovieListResponse.builder().movieResponseList(movieListResponses).totalPage(totalPage).build());
        return ResponseEntity.ok(responseData);
    }


    /**
     * API Lấy ra toàn bộ bản ghi của movies có trạng thái đang chiếu (1)
     * GET http://localhost:8080/api/v1/movies/movie-is-showing
     */
    @GetMapping("/movie-is-showing")
    public ResponseData getMoviesIsShowing() {
        return new ResponseData(HttpStatus.OK.value(), "Phim Đang Chiếu", movieService.getAllMoviesIsShowing(LocalDate.now(), LocalTime.now(), 1));
    }


    /**
     * API Lấy ra toàn bộ bản ghi của movies có trạng thái sắp chiếu
     * GET http://localhost:8080/api/v1/movies/movie-upcoming
     */
    @GetMapping("/movie-upcoming")
    public ResponseData getMoviesStatus3() {
        return new ResponseData(HttpStatus.OK.value(), "Phim Sắp Chiếu", movieService.getAllMovieUpcoming(LocalDate.now(), 3));
    }

    /**
     * API Lấy ra 1 bản ghi cho đối tượng có status là 1 và 3 theo id
     * GET http://localhost:8080/api/v1/movies/detail-movie/{{id}}/{{status}}
     */
    @GetMapping("/detail-movie/{id}/{status}")
    public ResponseData getDetailMovie(@PathVariable("id") Long id, @PathVariable("status") Integer status) {
        MovieResponse movieResponse = movieService.getDetailMovieByIdAndStatus(id, status);
        if (movieResponse != null) {
            if (status == 1 || status == 3) {
                return new ResponseData(HttpStatus.OK.value(), "Lấy được nhé", movieService.getDetailMovieByIdAndStatus(id, status));
            } else {
                return new ResponseError(HttpStatus.NO_CONTENT.value(), "Status = 2 nên không được lấy");
            }
        }
        return new ResponseError(HttpStatus.NO_CONTENT.value(), "Không có đối tượng nào được tìm thấy với id =" + id + " và status = " + status);
    }

    /**
     * API lấy ra phim bán vé trước
     * */
    @GetMapping("/movie-sell-ticket-in-advance")
    public  ResponseData getMovieSellTicketInAdvance(){
        return new ResponseData(HttpStatus.OK.value(), "Danh sach phim ban ve truoc",movieService.getMovieSellTicketInAdvance(LocalDate.now()));
    }


}
