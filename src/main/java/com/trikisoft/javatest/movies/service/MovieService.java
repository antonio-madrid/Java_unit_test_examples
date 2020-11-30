package com.trikisoft.javatest.movies.service;

import com.trikisoft.javatest.movies.data.MovieRepository;
import com.trikisoft.javatest.movies.model.Genre;
import com.trikisoft.javatest.movies.model.Movie;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMovieByLength(int length) {

        return movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= length ).collect(Collectors.toList());
    }

    public Collection<Movie> findByTemplate(Movie template) {

        if (template.getId() != null) {
            return Collections.singletonList(movieRepository.findById(template.getId()));
        }

        if (template.getMinutes() < 0) {
            throw new IllegalArgumentException("minutes cannot be negative");
        }

        Collection<Movie> filtered = movieRepository.findAll();

        return filtered.stream()
                .filter(movie -> template.getName() == null || movie.getName().toLowerCase().contains(template.getName().toLowerCase()))
                .filter(movie -> template.getMinutes() == null || movie.getMinutes() <= template.getMinutes())
                .filter(movie -> template.getGenre() == null || movie.getGenre() == template.getGenre())
                .filter(movie -> template.getDirector() == null || movie.getDirector().toLowerCase().contains(template.getDirector().toLowerCase()))
                .collect(Collectors.toList());
    }
}
