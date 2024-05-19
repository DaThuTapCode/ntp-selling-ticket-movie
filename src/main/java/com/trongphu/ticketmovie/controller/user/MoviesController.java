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
import java.util.List;
import java.util.UUID;
/**
 *
 * @author Trong Phu
 */
@RestController
@RequestMapping("${api.prefix}/movies")
@RequiredArgsConstructor //Tự động injection dependencies cho các biến final
public class MoviesController {

    private final MovieService movieService;

    //Trả về ảnh theo tên ảnh được truyền vào
   // GET http://localhost:8080/{{$placeholder}}/movies/images/{{imageName}}
    @GetMapping("images/{imageName}")
    public ResponseEntity<?> viewImage(@PathVariable String imageName) {
        try {
            java.nio.file.Path imagePath = Paths.get("uploads/"+imageName);
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
        int totalPage  = moviePage.getTotalPages();
        List<MovieResponse> movieListResponses = moviePage.getContent();

      ResponseData responseData =  new ResponseData<>(HttpStatus.OK.value(),"",MovieListResponse.builder().movieResponseList(movieListResponses).totalPage(totalPage).build());
        return ResponseEntity.ok(responseData);
    }

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
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


    /**
     * API Lấy ra toàn bộ bản ghi của movies
     * */
    @GetMapping("/all")
    public ResponseData getALlMovie(){
        return new ResponseData(HttpStatus.OK.value(), "All movies", movieService.findAllMovies());
    }

    /**
     * API Lấy ra toàn bộ bản ghi của movies có trạng thái đang chiếu (1)
     * */
    @GetMapping("/status1")
    public ResponseData getMoviesStatus1(){
        return new ResponseData(HttpStatus.OK.value(), "Movie status 1, Phim Đang Chiếu",movieService.getAllMoviesByStatus1());
    }

    /**
     * API Lấy ra toàn bộ bản ghi của movies có trạng thái ngừng chiếu (2)
     * */
    @GetMapping("/status2")
    public ResponseData getMoviesStatus2(){
        return new ResponseData(HttpStatus.OK.value(), "Movie status 2, Phim Ngừng Chiếu",movieService.getAllMoviesByStatus2());
    }

    /**
     * API Lấy ra toàn bộ bản ghi của movies có trạng thái sắp chiếu (3)
     * */
    @GetMapping("/status3")
    public ResponseData getMoviesStatus3(){
        return new ResponseData(HttpStatus.OK.value(), "Movie status 3, Phim Sắp Chiếu",movieService.getAllMoviesByStatus3());
    }

    /**
     * API Lấy ra 1 bản ghi cho đối tượng có status là 1 và 3 theo id
     * */
    @GetMapping("/detail-movie/{id}/{status}")
    public ResponseData getDetailMovie(@PathVariable("id") Long id, @PathVariable("status") Integer status) {
        MovieResponse movieResponse = movieService.getDetailMovieByIdAndStatus(id,status);
        if(movieResponse != null){
            if(status == 1 || status == 3){
                return new ResponseData(HttpStatus.OK.value(), "Lấy được nhé", movieService.getDetailMovieByIdAndStatus(id,status));
            }else {
                return new ResponseError(HttpStatus.NO_CONTENT.value(), "Status = 2 nên không được lấy");
            }
        }
        return new ResponseError(HttpStatus.NO_CONTENT.value(), "Không có đối tượng nào được tìm thấy với id =" + id + " và status = " + status);
    }



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
}
