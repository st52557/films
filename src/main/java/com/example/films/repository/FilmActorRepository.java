package com.example.films.repository;


import com.example.films.entity.Actor;
import com.example.films.entity.Film;
import com.example.films.entity.FilmActor;
import com.example.films.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmActorRepository extends JpaRepository<FilmActor, Long> {


    @Query(" select fa from FilmActor fa where fa.film.title = ?1 and fa.role = ?2")
    List<FilmActor> findAllFilmActorsByFilmNameAndByRole(String FilmName, RoleEnum role);


}
