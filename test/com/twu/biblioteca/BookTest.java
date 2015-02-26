package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    Book unavailableBook;
    Book availableBook;

    @Before
    public void setUp() {
        unavailableBook = new Book("The Grapes of Wrath", "John Steinbeck", 1939, true);
        availableBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, false);
    }

    @Test
    public void shouldCreateBookWhenValidDataIsGiven() {
        Book newBook = new Book("Head First Java", "Bert Bates and Kathy Sierra", 2004, false);
        assertNotNull(newBook);
        assertTrue(BookCollection.collection.contains(newBook));
    }

    @Test
    public void shouldCheckoutBookWhenIsAvailable() {
        assertTrue(availableBook.checkout());
    }

    @Test
    public void shouldNotCheckoutBookWhenIsUnavailable() {
        assertFalse(unavailableBook.checkout());
    }

    @Test
    public void shouldGiveAvailableBookDetailsInStringFormat() {
        String[] bookData = new String[]{"The Great Gatsby", "F. Scott Fitzgerald", "1925", "Available"};
        assertArrayEquals(availableBook.getData(), bookData);
    }

    public void shouldGiveUnavailableBookDetailsInStringFormat() {
        String[] bookData = new String[]{"The Grapes of Wrath", "John Steinbeck", "1939", "Unavailable"};
        assertArrayEquals(unavailableBook.getData(), bookData);
    }
}