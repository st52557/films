package com.example.films;

import com.example.films.entity.Actor;
import com.example.films.entity.Film;
import com.example.films.entity.FilmActor;
import com.example.films.entity.RoleEnum;
import com.example.films.repository.ActorRepository;
import com.example.films.repository.FilmActorRepository;
import com.example.films.repository.FilmRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FilmActorRepositoryTest {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private FilmActorRepository filmActorRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Test
    void assignActorToFilmTest() {

        Film film = new Film();
        film.setTitle("Avatar");
        filmRepository.save(film);

        Actor actor = new Actor();
        actor.setName("David");
        actor.setSurname("Cameron");
        actorRepository.save(actor);

        FilmActor filmActor = new FilmActor();
        filmActor.setActor(actor);
        filmActor.setFilm(film);
        filmActor.setRole(RoleEnum.DIRECTOR);
        filmActorRepository.save(filmActor);

        List<FilmActor> foundFilmActors = filmActorRepository.findAllFilmActorsByFilmNameAndByRole("Avatar", RoleEnum.DIRECTOR);

        Assertions.assertThat(foundFilmActors.get(0).getActor().getName()).isEqualTo("David");

    }

}
