package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldCreateBookWhenValidDataIsGiven() {
        assertNotNull(new Book("Head First Java", "Bert Bates and Kathy Sierra", 2004, false));
    }

    @Test
    public void shouldCheckoutBookWhenIsAvailable() {
        Book book1 = new Book("Head First Java", "Bert Bates and Kathy Sierra", 2004, false);
        assertTrue(book1.checkout());
    }

    @Test
    public void shouldNotCheckoutBookWhenIsUnavailable() {
        Book book2 = new Book("Head First Java", "Bert Bates and Kathy Sierra", 2004, true);
        assertFalse(book2.checkout());
    }


}