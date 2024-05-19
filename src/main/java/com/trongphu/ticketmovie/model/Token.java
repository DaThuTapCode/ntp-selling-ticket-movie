package com.trongphu.ticketmovie.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
/**
 *
 * @author Trong Phu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "tokens")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    private  String tokentype;


    private LocalDateTime expirationdate;

    private boolean revoked;

    private boolean expired;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;

}
