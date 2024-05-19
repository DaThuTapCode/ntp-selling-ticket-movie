package com.trongphu.ticketmovie.repository;

import com.trongphu.ticketmovie.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 *
 * @author Trong Phu
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {
    boolean existsByTitle(String title);

    Page<Movie> findAll(Pageable pageable); // phan trang

    Page<Movie> findByStatus(Integer status, Pageable pageable);

    List<Movie> findByStatus(Integer status);

    Movie findByIdAndStatus(Long id, Integer status);
}
