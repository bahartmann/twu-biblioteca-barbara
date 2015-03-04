package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("| " +
                stringWithExtraCharacters("                 TITLE", 40) + "| " +
                stringWithExtraCharacters("                 AUTHOR", 40) + "| " +
                stringWithExtraCharacters("YEAR", 5) + "|");

        for (Book book : this.collection) {
            if (book.isAvailable()){
                System.out.println("| " +
                        stringWithExtraCharacters(book.getTitle(), 40) + "| " +
                        stringWithExtraCharacters(book.getAuthor(), 40) + "| " +
                        stringWithExtraCharacters(String.valueOf(book.getYear()), 5)+ "|");
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

    private static String stringWithExtraCharacters(String string, int length) {
        return String.format("%1$-"+length+ "s", string);
    }
}
