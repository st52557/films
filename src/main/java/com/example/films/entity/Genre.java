package com.example.films.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String genre;

    @OneToMany(mappedBy = "id")
    private Set<FilmGenre> filmGenres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<FilmGenre> getFilmGenres() {
        return filmGenres;
    }

    public void setFilmGenres(Set<FilmGenre> filmGenres) {
        this.filmGenres = filmGenres;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
