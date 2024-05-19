package com.trongphu.ticketmovie.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
/**
 *
 * @author Trong Phu
 */
@Entity( name = "roles")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date createat;

//    @OneToMany(mappedBy = "role")
//    private List<UserRole> userroles;
}
