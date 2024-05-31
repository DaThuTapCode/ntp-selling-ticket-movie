package com.trongphu.ticketmovie.model;

import com.trongphu.ticketmovie.util.StatusUserEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
@Builder
public class User implements UserDetails {
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

    private LocalDate createdat;

    private LocalDate updateat;

    @Enumerated(EnumType.STRING)
    private StatusUserEnum status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_"+ this.role.getName()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


//    //@JsonIgnore
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    private List<UserRole> useroles;

    //@JsonIgnore
//    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
//    private List<Booking> bookings;

}
