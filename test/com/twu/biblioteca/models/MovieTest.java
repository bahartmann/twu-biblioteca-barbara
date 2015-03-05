package com.twu.biblioteca.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MovieTest {

    private Movie unavailableMovie;
    private Movie availableMovie;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private UserAccount user;

    @Before
    public void setUp() {
        unavailableMovie = new Movie("The Good, the Bad and the Ugly", "Sergio Leone", 1966, 8.9);
        unavailableMovie.setCheckedOut(true);
        availableMovie = new Movie("Pulp Fiction", "Quentin Tarantino", 1994, 8.8);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldCreateMovieWhenValidDataIsGiven() {
        Movie newMovie = new Movie("Casablanca", "Michael Curtiz", 1942, 8);
        assertNotNull(newMovie);
    }

    @Test
    public void successfulCheckout() {
        availableMovie.checkout(user);
        assertEquals("Thank you! Enjoy the movie\n", outContent.toString());
    }

    @Test
    public void unsuccessfulCheckout() {
        unavailableMovie.checkout(user);
        assertEquals("That movie is not available.\n", outContent.toString());
    }

}