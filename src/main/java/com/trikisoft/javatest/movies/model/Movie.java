package com.trikisoft.javatest.movies.model;

import java.util.Objects;

public class Movie {

    private final String name;
    private Integer id;
    private Integer minutes;
    private Genre genre;
    private String director;

    public Movie(String name, int minutes) {
        this.name = name;
        this.minutes = minutes;
    }

    public Movie(String name, int minutes, Genre genre) {
        this(name, minutes);
        this.genre = genre;
    }

    public Movie(String name, int minutes, String director) {
        this(name, minutes);
        this.director = director;
    }

    public Movie(String name, int minutes, Genre genre, String director) {
        this(name, minutes, genre);
        this.director = director;
    }

    public Movie(Integer id, String name, int minutes, Genre genre, String director) {
        this(name, minutes, genre, director);
        this.id = id;
    }

    public Movie(String name, Genre genre) {
        this.name = name;
        this.genre = genre;
    }

    public Movie(String name, Genre genre, String director) {
        this(name, genre);
        this.director = director;
    }


    public String getDirector() {
        return director;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(minutes, movie.minutes) &&
                Objects.equals(id, movie.id) &&
                Objects.equals(name, movie.name) &&
                genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, genre);
    }
}
