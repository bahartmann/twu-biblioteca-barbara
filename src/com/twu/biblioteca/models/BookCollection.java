package com.twu.biblioteca.models;

import com.twu.biblioteca.lib.Resizer;

import java.util.*;

public class BookCollection {

    private static BookCollection instance;

    public static synchronized BookCollection getInstance(){
        if (instance == null)
            instance = new BookCollection();
        return instance;
    }

    private BookCollection(){};

    private static List<Book> collection = new ArrayList<Book>();

    public void addBook(Book book) {
        collection.add(book);
    }

    public void printBooksTable() {
        Resizer resizer = new Resizer();

        System.out.println("| " +
                resizer.addCharacters("TITLE", 40) +
                resizer.addCharacters("AUTHOR", 40) +
                resizer.addCharacters("YEAR", 5));

        for (Book book : this.collection) {
            if (book.isAvailable()){
                System.out.println("| " +
                        resizer.addCharacters(book.getTitle(), 40) +
                        resizer.addCharacters(book.getAuthor(), 40) +
                        resizer.addCharacters(String.valueOf(book.getYear()), 5));
            }
        }
    }

    public Book searchBook(String userSearch) {
        for (Book book : this.collection) {
            if (userSearch.equalsIgnoreCase(book.getTitle()))
                return book;
        }
        System.out.println("Book not found.");
        return null;
    }
}
