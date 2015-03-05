package com.twu.biblioteca.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by bhartman on 3/5/15.
 */
public class MovieCollectionTest {
    private MovieCollection mCollect1 = null, mCollect2 = null;
    private Movie exampleMovie;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        mCollect1 = MovieCollection.getInstance();
        mCollect2 = MovieCollection.getInstance();

        exampleMovie = new Movie("Casablanca", "Michael Curtiz", 1942, 8);
        exampleMovie.setCheckedOut(true);
        mCollect1.addMovie(exampleMovie);
        mCollect1.addMovie(new Movie("Pulp Fiction", "Quentin Tarantino", 1994, 8.8));
        mCollect1.addMovie(new Movie("The Good, the Bad and the Ugly", "Sergio Leone", 1966, 8.9));

        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldHaveOnlyOneInstance() throws Exception {
        assertTrue(mCollect1 == mCollect2);
    }

    @Test
    public void shouldPrintAllAvailableBooks() {
        mCollect1.printMoviesTable();
        String collectionTable = "| TITLE                                   | DIRECTOR                                | YEAR | RATING  | \n" +
                                 "| Pulp Fiction                            | Quentin Tarantino                       | 1994 | 8.8     | \n" +
                                 "| The Good, the Bad and the Ugly          | Sergio Leone                            | 1966 | 8.9     | \n";
        assertEquals(collectionTable, outContent.toString());
    }

    @Test
    public void searchInvalidBook() {
        Movie movie = mCollect1.searchMovie("Invalid Movie bla bla");
        assertEquals("Movie not found.\n", outContent.toString());
        assertNull(movie);
    }

    @Test
    public void searchValidBook() {
        Movie movie = mCollect1.searchMovie("Casablanca");
        assertEquals(movie.getDirector(), exampleMovie.getDirector());
    }
}
