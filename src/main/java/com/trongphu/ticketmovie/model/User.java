package com.trongphu.ticketmovie.model;

import com.trongphu.ticketmovie.util.StatusUserEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private Role role;

    private Integer facebookacountid;

    private Integer googleacountid;

    private String username;

    private String fullname;

    private String password;

    private String email;

    private String image;

    private Date createdat;

    private Date updateat;

    @Enumerated(EnumType.STRING)
    private StatusUserEnum status;


//    //@JsonIgnore
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    private List<UserRole> useroles;

    //@JsonIgnore
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    private List<Booking> bookings;

}
