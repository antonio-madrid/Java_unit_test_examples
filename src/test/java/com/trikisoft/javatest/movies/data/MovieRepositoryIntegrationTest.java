package com.trikisoft.javatest.movies.data;

import com.trikisoft.javatest.movies.model.Genre;
import com.trikisoft.javatest.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MovieRepositoryIntegrationTest {

    private MovieRepositoryJdbc movieRepositoryJdbc;
    private DataSource dataSource;

    @Before
    public void setUp() throws SQLException {
        dataSource =
                new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() {
        Collection<Movie> movies = movieRepositoryJdbc.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "Lana Wachowski, Lilly Wachowski"),
                new Movie(4, "Super 8", 112, Genre.THRILLER, "J.J. Abrams"),
                new Movie(5, "Superman", 184, Genre.ACTION, "Richard Donner")
                ))
        );
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepositoryJdbc.findById(2);

        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan")));
    }

    @Test
    public void insert_a_movie() {

        Movie movie = new Movie(4, "Super 8", 112, Genre.THRILLER, "J.J. Abrams");

        movieRepositoryJdbc.saveOrUpdate(movie);

        Movie movieFromDB = movieRepositoryJdbc.findById(4);

        assertThat(movieFromDB, is(movie));
    }

    @Test
    public void load_movie_by_name() {

        String movieName = "Super";
        Collection<Movie> movies = movieRepositoryJdbc.findByName(movieName);

        assertThat(movies, is(Arrays.asList(
                new Movie(4, "Super 8", 112, Genre.THRILLER, "J.J. Abrams"),
                new Movie(5, "Superman", 184, Genre.ACTION, "Richard Donner")
                ))
        );

        movieName = "super";
        movies = movieRepositoryJdbc.findByName(movieName);

        assertThat(movies, is(Arrays.asList(
                new Movie(4, "Super 8", 112, Genre.THRILLER, "J.J. Abrams"),
                new Movie(5, "Superman", 184, Genre.ACTION, "Richard Donner")
                ))
        );
    }

    @Test
    public void load_movie_by_director_name() {
        String directorName = "Christo";
        Collection<Movie> movies = movieRepositoryJdbc.findByDirector(directorName);

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan")
            ))
        );

        directorName = "christoPHER";
        movies = movieRepositoryJdbc.findByDirector(directorName);

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan")
            ))
        );
    }

    @After
    public void tearDown() throws SQLException {
        // Remove H2 files
        final Statement statement = dataSource.getConnection().createStatement();
        statement.execute("DROP ALL objects DELETE files");
    }
}