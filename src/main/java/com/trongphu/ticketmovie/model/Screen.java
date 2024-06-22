package com.trongphu.ticketmovie.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trongphu.ticketmovie.util.TypeScreenEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author Trong Phu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "screens")
@Builder
public class Screen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "theaterid")
    private Theater theater;

    @Size(min = 1, max = 100, message = "Tên phòng chiếu 1 đến 100 ký tự!")
    private String name;

   // @Enumerated(EnumType.STRING)
   @Size(min = 1, max = 100, message = "Loại phòng chiếu 1 đến 100 ký tự!")
   private String type;

    @OneToMany(mappedBy = "screen")
    @JsonIgnore
    private List<ShowTime> showTimes;

}
