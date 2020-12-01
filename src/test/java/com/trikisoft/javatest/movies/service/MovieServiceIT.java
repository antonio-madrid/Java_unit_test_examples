package com.trikisoft.javatest.movies.service;

import com.trikisoft.javatest.movies.data.MovieRepository;
import com.trikisoft.javatest.movies.model.Genre;
import com.trikisoft.javatest.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class MovieServiceIT {

    private MovieService movieService;
    private Movie movieTemplate;
    private Collection<Movie> movies;

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
        movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieIds(movies), is(Arrays.asList(3, 6)));
    }

    @Test
    public void should_return_movies_by_length() {
        movies = movieService.findMovieByLength(119);

        assertThat(getMovieIds(movies), is(Arrays.asList(2, 3, 4, 5, 6)));

    }

    @Test
    public void should_return_action_movies_shorter_than_2_hours() {
        // 150m = 2h 30m
        movieTemplate = new Movie(null, 150, Genre.ACTION);
        movies = movieService.findByTemplate(movieTemplate);

        assertThat(getMovieIds(movies), is(Collections.singletonList(7)));
    }

    @Test
    public void should_return_movies_by_name_and_duration() {
        movieTemplate = new Movie("ma", 150);
        movies = movieService.findByTemplate(movieTemplate);

        assertThat(getMovieIds(movies), is(Arrays.asList(3, 7)));
    }

    @Test
    public void should_return_movies_by_name_by_duration_and_director() {
        movieTemplate = new Movie("ma", 119, "Peter Farrelly");
        movies = movieService.findByTemplate(movieTemplate);

        assertThat(getMovieIds(movies), is(Collections.singletonList(3)));

        movieTemplate = new Movie("", 152, "Nolan");
        movies = movieService.findByTemplate(movieTemplate);

        assertThat(getMovieIds(movies), is(Arrays.asList(1, 2)));
    }

    @Test
    public void should_return_movies_by_name_and_genre() {
        movieTemplate = new Movie("su", Genre.THRILLER);
        movies = movieService.findByTemplate(movieTemplate);

        assertThat(getMovieIds(movies), is(Collections.singletonList(4)));

        movieTemplate = new Movie("a", Genre.ACTION);
        movies = movieService.findByTemplate(movieTemplate);

        assertThat(getMovieIds(movies), is(Arrays.asList(1, 7)));
    }

    @Test
    public void should_return_movies_by_name_by_genre_and_director() {
        movieTemplate = new Movie("su", Genre.THRILLER, "Abrams");
        movies = movieService.findByTemplate(movieTemplate);

        assertThat(getMovieIds(movies), is(Collections.singletonList(4)));

        movieTemplate = new Movie("su", Genre.THRILLER, "p");
        movies = movieService.findByTemplate(movieTemplate);

        assertThat(getMovieIds(movies), not(Collections.singletonList(4)));
    }

    @Test
    public void should_return_movies_by_genre_and_duration() {
        movieTemplate = new Movie(null, 112, Genre.THRILLER);
        movies = movieService.findByTemplate(movieTemplate);

        assertThat(getMovieIds(movies), is(Collections.singletonList(4)));

        movieTemplate = new Movie(null, 120, Genre.COMEDY);
        movies = movieService.findByTemplate(movieTemplate);

        assertThat(getMovieIds(movies), is(Arrays.asList(3, 6)));
    }

    @Test
    public void should_return_movies_by_genre_by_duration_and_director() {
        movieTemplate = new Movie(null, 112, Genre.THRILLER, "Abrams");
        movies = movieService.findByTemplate(movieTemplate);

        assertThat(getMovieIds(movies), is(Collections.singletonList(4)));

        movieTemplate = new Movie(null, 120, Genre.COMEDY, "o");
        movies = movieService.findByTemplate(movieTemplate);

        assertThat(getMovieIds(movies), is(Arrays.asList(3, 6)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

}