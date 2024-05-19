package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Trong Phu
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String userName);

    User findByUsername(String userName);
}
