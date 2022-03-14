package com.example.films.repository;

import com.example.films.entity.Genre;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @EntityGraph(attributePaths =  "FilmGenre")
    Optional<Genre> findById(Long id);

}
