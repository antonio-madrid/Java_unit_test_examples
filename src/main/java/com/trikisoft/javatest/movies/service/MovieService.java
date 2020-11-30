package com.trikisoft.javatest.movies.service;

import com.trikisoft.javatest.movies.data.MovieRepository;
import com.trikisoft.javatest.movies.model.Genre;
import com.trikisoft.javatest.movies.model.Movie;

import java.util.Collection;
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
}
