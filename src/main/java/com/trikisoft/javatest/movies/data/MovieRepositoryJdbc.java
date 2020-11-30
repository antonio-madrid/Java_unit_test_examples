package com.trikisoft.javatest.movies.data;

import com.trikisoft.javatest.movies.model.Genre;
import com.trikisoft.javatest.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieRepositoryJdbc implements MovieRepository {

    private static final RowMapper<Movie> movieMapper = (rs, rowNum) ->
            new Movie(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    // DB returns a String, we must to parse it to an enum
                    Genre.valueOf(rs.getString("genre")),
                    rs.getString("director"));
//                    director);

    private final JdbcTemplate jdbcTemplate;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        return jdbcTemplate.queryForObject("SELECT * FROM movies WHERE id = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        return jdbcTemplate.query("SELECT * FROM movies", movieMapper);
    }

    // TODO: refactor saveOrUpdate to save
    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplate.update("INSERT INTO movies (name, minutes, genre) VALUES (?, ?, ?)",
                movie.getName(), movie.getMinutes(), movie.getGenre().toString());
    }

    @Override
    public Collection<Movie> findByName(String movieName) {

        Collection<Movie> movies = jdbcTemplate.query("SELECT * FROM movies", movieMapper);
        return movies.stream()
                .filter(movie -> movie.getName().toLowerCase().contains(movieName.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Movie> findByDirector(String directorName) {
        Collection<Movie> movies = jdbcTemplate.query("SELECT * FROM movies", movieMapper);

        return movies.stream()
                .filter(movie -> movie.getDirector().toLowerCase().contains(directorName.toLowerCase()))
                .collect(Collectors.toList());
    }
}
