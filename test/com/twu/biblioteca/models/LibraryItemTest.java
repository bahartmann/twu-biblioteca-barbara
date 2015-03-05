package com.twu.biblioteca.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryItemTest {

    private LibraryItem availableItem;
    private LibraryItem unavailableItem;
    private UserAccount user;

    @Before
    public void setUp() {
        unavailableItem = new Book("The Grapes of Wrath", "John Steinbeck", 1939, true);
        availableItem = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, false);
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void checkoutAvailableItem() {
        assertTrue(availableItem.checkoutItem(user));
        assertFalse (availableItem.isAvailable());
    }

    @Test
    public void checkoutUnavailableItem() {
        assertFalse(unavailableItem.checkoutItem(user));
    }

    @Test
    public void returnAvailableItem() {
        assertFalse(availableItem.returnItem());
    }

    @Test
    public void returnUnavailableItem() {
        assertTrue(unavailableItem.returnItem());
        assertTrue(unavailableItem.isAvailable());
    }
}