package com.example.films;


import com.example.films.entity.Film;
import com.example.films.repository.FilmRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class FilmRepositoryTest {


    @Autowired
    private FilmRepository filmRepository;

//    @Autowired
//    private FilmGenreRepository filmGenreRepository;
//
//    @Autowired
//    private GenreRepository genreRepository;


    @Test
    void findFilmByTitleContainsTest() {

        Film film = new Film();
        film.setTitle("Avatar");
        filmRepository.save(film);

        String foundTitle = filmRepository.findFilmByTitleContains("Avatar").getTitle();

        Assertions.assertThat(foundTitle).isEqualTo(film.getTitle());

    }
    @Test
    void findFilmByYearTest() {

        Film film = new Film();
        film.setTitle("Inglorious bastards");
        film.setYear(2009);
        filmRepository.save(film);

        Film film2 = new Film();
        film2.setTitle("Django Unchained");
        film2.setYear(2012);
        filmRepository.save(film2);

        int foundFilms = filmRepository.findFilmByYearBetween(2007, 2010).size();

        Assertions.assertThat(foundFilms).isEqualTo(1);

    }


    @Test
    void createFilmTest() {

        int before = filmRepository.findAll().size();

        Film film = new Film();
        film.setTitle("Tmavomodrý svět");
        filmRepository.save(film);

        int after = filmRepository.findAll().size();

        System.out.println("LOG: "+before + " - "+ after);

        Assertions.assertThat(before+1).isEqualTo(after);

    }

    @Test
    void findAllFilmTest() {

        Assertions.assertThat(1).isEqualTo(1);
        int before = filmRepository.findAll().size();

        Film film = new Film();
        film.setTitle("Tmavomodrý svět");
        filmRepository.save(film);

        Film film2 = new Film();
        film2.setTitle("Avatar");
        filmRepository.save(film2);

        int after = filmRepository.findAll().size();

        Assertions.assertThat(before+2).isEqualTo(after);

    }

}
