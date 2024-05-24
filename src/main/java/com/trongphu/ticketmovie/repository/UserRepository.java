package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 *
 * @author Trong Phu
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String userName);

    boolean existsByEmail(String email);
    //User findByUsername(String userName);

    Optional<User> findByUsername(String username);
}
