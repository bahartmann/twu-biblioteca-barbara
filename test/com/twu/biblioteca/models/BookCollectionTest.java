package com.twu.biblioteca.models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class BookCollectionTest {

    private BookCollection collectionOne = null, collectionTwo = null;
    private Book exampleBook;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        collectionOne = BookCollection.getInstance();
        collectionTwo = BookCollection.getInstance();

        exampleBook = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, false);
        collectionOne.addBook(exampleBook);
        collectionOne.addBook(new Book("Head First Java", "Bert Bates and Kathy Sierra", 2004, false));
        collectionOne.addBook(new Book("The Grapes of Wrath", "John Steinbeck", 1939, true));

        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldHaveOnlyOneInstance() throws Exception {
        assertTrue(collectionOne == collectionTwo);

    }

    @Test
    public void shouldPrintAllAvailableBooks() {
        collectionOne.printBooksTable();
        String collectionTable = "|                  TITLE                  |                  AUTHOR                 | YEAR |\n" +
                                 "| The Great Gatsby                        | F. Scott Fitzgerald                     | 1925 |\n" +
                                 "| Head First Java                         | Bert Bates and Kathy Sierra             | 2004 |\n";
        assertEquals(collectionTable, outContent.toString());
    }

    @Test
    public void searchInvalidBook() {
        Book book = collectionOne.searchBook("Some Invalid Book");
        assertEquals("Book not found.\n", outContent.toString());
        assertNull(book);
    }

    @Test
    public void searchValidBook() {
        Book book = collectionOne.searchBook("The Great Gatsby");
            assertEquals(exampleBook.getAuthor(), book.getAuthor());
    }
}