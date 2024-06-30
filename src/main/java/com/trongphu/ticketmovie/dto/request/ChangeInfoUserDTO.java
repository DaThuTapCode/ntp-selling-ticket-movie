package com.trongphu.ticketmovie.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Trong Phu on 6/24/2024 10:23:16
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangeInfoUserDTO {
    @Email(message = "Sai định dạng email!")
    @NotEmpty(message = "Email là bắt buộc")
    private String email;

    @Size(min = 3, max = 100, message = "Tên từ 3 đến 100 ký tự!")
    private String fullname;

    private MultipartFile file;

}
