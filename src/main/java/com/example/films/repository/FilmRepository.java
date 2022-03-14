package com.example.films.repository;


import com.example.films.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    Film findFilmByTitleContains(String contains);


    @Query(" select p from Film p where p.id between ?1 and ?2")
    List<Film> findFilmByIdBetween(Long start, Long end);

    @Query(" select p from Film p where p.year between ?1 and ?2")
    List<Film> findFilmByYearBetween(int start, int end);


}
