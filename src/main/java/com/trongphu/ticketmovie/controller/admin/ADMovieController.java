package com.trongphu.ticketmovie.controller.admin;


import com.trongphu.ticketmovie.dto.request.MoviesDTO;
import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.dto.respone.ResponseError;
import com.trongphu.ticketmovie.dto.respone.ResponsePageData;
import com.trongphu.ticketmovie.model.Movie;
import com.trongphu.ticketmovie.responsedata.MovieResponse;
import com.trongphu.ticketmovie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Trong Phu
 */
@RestController
@RequestMapping("/api/v1/admin/movies")
@RequiredArgsConstructor
public class ADMovieController {
    private final MovieService movieService;

    /**
     * API Lấy ra toàn bộ bản ghi của movies
     * GET http://localhost:8080/api/v1/admin/movies/all
     */
    @GetMapping("/all")
    public ResponseData getAllMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        Page<Movie> moviePage = movieService.findPageAllMovies(pageable);
        return new ResponsePageData(HttpStatus.OK.value(), "All movies", moviePage.getContent(), moviePage.getTotalElements());
    }

    /**
     * API Lấy ra toàn bộ bản ghi của movies có trạng thái ngừng chiếu (2)
     * GET http://localhost:8080/api/v1/admin/movies/status2
     */
    @GetMapping("/status2")
    public ResponseData getMoviesStatus2() {
        return new ResponseData(HttpStatus.OK.value(), "Movie status 2, Phim Ngừng Chiếu", movieService.getAllMoviesByStatus2());
    }

    /**
     * API lấy ra toàn bộ phim ở trạng thái 1
     * */
    @GetMapping("status1")
    private ResponseEntity<ResponseData> getAllMovieStatus1(){
        List<MovieResponse> movieList = movieService.getAllMovieByStatus();
        return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Get all movieStatus1", movieList), HttpStatus.OK);
    }
    
    /**
     * API thêm 1 phim mới
     * POST http://localhost:8080/api/v1/admin/movies/add
     */
    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseData> createMovies(
            @Valid @ModelAttribute MoviesDTO moviesDTO
    ) throws Exception {
        MultipartFile file = moviesDTO.getFile();
        if (file != null && !file.isEmpty()) {
            if (file.getSize() > 10 * 1024 * 1024) {
                return new ResponseEntity<>(new ResponseData(HttpStatus.PAYLOAD_TOO_LARGE.value(), "File phải nhỏ hơn 10MB"), HttpStatus.PAYLOAD_TOO_LARGE);
            }
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                return new ResponseEntity<>(new ResponseData(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), "File phải là ảnh!"), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
            }
            String filename = storeFile(file);
            moviesDTO.setImage(filename);
          Movie movie =   movieService.crateMovie(moviesDTO);
            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Movies created successfully!", movie
            ), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ResponseData(HttpStatus.BAD_REQUEST.value(), "Ảnh chưa được chọn!"), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ResponseData> updateMOvie(
            @PathVariable Long id,
            @Valid @ModelAttribute MoviesDTO moviesDTO
    )throws Exception {
        MultipartFile file = moviesDTO.getFile();
        if (file != null && !file.isEmpty()) {
            if (file.getSize() > 10 * 1024 * 1024) { // Kích thước lớn hơn 10MB
                return new ResponseEntity<>(new ResponseData(HttpStatus.PAYLOAD_TOO_LARGE.value(), "File phải nhỏ hơn 10MB"), HttpStatus.PAYLOAD_TOO_LARGE);
            }
            String contentType = file.getContentType();
            if (contentType == null || !contentType.startsWith("image/")) {
                return new ResponseEntity<>(new ResponseData(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(), "File phải là ảnh!"), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
            }
            String filename = storeFile(file);
            moviesDTO.setImage(filename);
            Movie movie =   movieService.updateMovie(id, moviesDTO);
            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Sửa phim thành công!", movie
            ), HttpStatus.OK);
        } else {
            Movie movie =   movieService.updateMovie(id, moviesDTO);
            return new ResponseEntity<>(new ResponseData(HttpStatus.OK.value(), "Sửa phim thành công!", movie
            ), HttpStatus.OK);        }
    }


    /**
     * Method trả về 1 tên file đã được xử lý
     * Tạo 1 UUID rồi ghép tên ảnh vào đảm bảo file name không trùng
     * Thực hiện tạo thư mục uploads nếu chưa tồn tại
     */
    private String storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
        Path uploadDir = Paths.get("uploads");
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        Path destination = Paths.get(uploadDir.toString(), uniqueFileName);
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFileName;
    }

}
