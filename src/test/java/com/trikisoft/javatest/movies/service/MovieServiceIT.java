package com.trikisoft.javatest.movies.service;

import com.trikisoft.javatest.movies.data.MovieRepository;
import com.trikisoft.javatest.movies.model.Genre;
import com.trikisoft.javatest.movies.model.Movie;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MovieServiceIT {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);
        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"),
                        new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan"),
                        new Movie(3, "There's Something About Mary", 119, Genre.COMEDY, "Bobby Farrelly, Peter Farrelly"),
                        new Movie(4, "Super 8", 112, Genre.THRILLER, "J.J. Abrams"),
                        new Movie(5, "Scream", 111, Genre.HORROR, "Wes Craven"),
                        new Movie(6, "Home Alone", 103, Genre.COMEDY, "Chris Columbus"),
                        new Movie(7, "Matrix", 136, Genre.ACTION, "Lana Wachowski, Lilly Wachowski")
                )
        );
        movieService = new MovieService(movieRepository);
    }

    // Example of service testing
    @Test
    public void should_return_movies_by_genre() {
        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieIds(movies), is(Arrays.asList(3, 6)));
    }

    @Test
    public void should_return_movies_by_length() {
        Collection<Movie> movies = movieService.findMovieByLength(119);

        assertThat(getMovieIds(movies), is(Arrays.asList(2, 3, 4, 5, 6)));

    }

    @Test
    public void should_return_action_movies_shorter_than_2_hours() {
        // 150m = 2h 30m
        Movie template = new Movie(null, 150, Genre.ACTION);
        Collection<Movie> movies = movieService.findByTemplate(template);

        assertThat(getMovieIds(movies), is(Collections.singletonList(7)));

        // nombre y genero
        // genero y duracion

    }

    @Test
    public void should_return_movies_by_name_and_duration() {
        Movie template = new Movie("ma", 150);
        Collection<Movie> movies = movieService.findByTemplate(template);

        assertThat(getMovieIds(movies), is(Arrays.asList(3, 7)));
    }

    @Test
    public void should_return_movies_by_name_and_genre() {
        Movie template = new Movie("su", Genre.THRILLER);
        Collection<Movie> movies = movieService.findByTemplate(template);

        assertThat(getMovieIds(movies), is(Collections.singletonList(4)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

}