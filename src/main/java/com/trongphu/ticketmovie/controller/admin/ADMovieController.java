package com.trongphu.ticketmovie.controller.admin;


import com.trongphu.ticketmovie.dto.request.MoviesDTO;
import com.trongphu.ticketmovie.dto.respone.ResponseData;
import com.trongphu.ticketmovie.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

/**
 * @author Trong Phu
 */
@RestController
@RequestMapping("/api/v1/admin/movies")
@RequiredArgsConstructor
public class ADMovieController {
    private final MovieService movieService;

    /**
     * Method trả về 1 tên file đã được xử lý
     * Tạo 1 UUID rồi ghép tên ảnh vào đảm bảo file name không trùng
     * Thực hiện tạo thư mục uploads nếu chưa tồn tại
     */
    private String storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //Them UUID vao truc tiep file de dam bao ten file la duy nhat!!
        String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
        //Duong dan den thu muc ban muon luu  /////file java.nio.file
        Path uploadDir = Paths.get("uploads");
        //Kiem tra va tao thu muc ne no khong ton tai
        if (!Files.exists(uploadDir)) {
            Files.createDirectories(uploadDir);
        }
        //DUong dan day du den file
        Path destination = Paths.get(uploadDir.toString(), uniqueFileName);
        //Sao chep file vao thu muc dich
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFileName;
    }

    /**
     * API Lấy ra toàn bộ bản ghi của movies
     * GET http://localhost:8080/api/v1/admin/movies/all
     */
    @GetMapping("/all")
    public ResponseData getALlMovie() {
        return new ResponseData(HttpStatus.OK.value(), "All movies", movieService.findAllMovies());
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
     * API thêm 1 phim mới
     * POST http://localhost:8080/api/v1/admin/movies/add
     */
    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createMovies(@Valid @ModelAttribute MoviesDTO moviesDTO,
                                          //@RequestPart("file") MultipartFile file,
                                          BindingResult result) {
        try {
            if (result.hasErrors()) {
                List<String> errorMessage = result
                        .getFieldErrors()
                        .stream().map(FieldError::getDefaultMessage).toList();
            }

            MultipartFile file = moviesDTO.getFile();
            System.out.println(file.getName());
            if (file != null) {
                //Kiem tra kich thuoc file
                if (file.getSize() > 10 * 1024 * 1024) { //Kich thuoc lon hon 10mb
                    return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
                            .body("File is to large! Maximum size is 10mb");
                }
                //Kiem tra dinh dang file
                String contentType = file.getContentType();
                if (contentType == null || !contentType.startsWith("image/")) {
                    return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                            .body("File must be an image!");
                }
                // Luu file va cap nhat image trong moviesDTO
                String filename = storeFile(file);
                moviesDTO.setImage(filename);
                // thay the ham nay voi code de luu file
                //Luu vao doi tuong movies trong DB => Se lam sau
                movieService.crateMovie(moviesDTO);
            }
            return ResponseEntity.ok("Movies created successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
