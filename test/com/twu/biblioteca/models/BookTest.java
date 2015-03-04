package com.twu.biblioteca.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BookTest {

    private Book unavailableBook;
    private Book availableBook;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        unavailableBook = new Book("The Grapes of Wrath", "John Steinbeck", 1939, true);
        availableBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, false);
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldCreateBookWhenValidDataIsGiven() {
        Book newBook = new Book("Head First Java", "Bert Bates and Kathy Sierra", 2004, false);
        assertNotNull(newBook);
    }

    @Test
    public void successfulCheckout() {
        availableBook.checkout();
        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void unsuccessfulCheckout() {
        unavailableBook.checkout();
        assertEquals("That book is not available.\n", outContent.toString());
    }

    @Test
    public void successfulReturn() {
        unavailableBook.returning();
        assertTrue(availableBook.isAvailable());
        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void unsuccessfulReturn() {
        availableBook.returning();
        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }
}