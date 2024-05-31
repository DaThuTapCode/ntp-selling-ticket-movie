package com.trongphu.ticketmovie.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
/**
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolesDTO {

    @NotEmpty(message = "Name roles cannot be empty!!")
    private String name;

    private String description;

    private LocalDate createat;
}
