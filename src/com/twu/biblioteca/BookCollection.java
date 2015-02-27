package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BookCollection {

    public static List<Book> collection = new ArrayList<Book>();
    public static void add(Book book) {
        collection.add(book);
    }

    public static void printBooksTable() {
        System.out.println("| " +
                stringWithExtraCharacters("                 TITLE", 40) + "| " +
                stringWithExtraCharacters("                 AUTHOR", 40) + "| " +
                stringWithExtraCharacters("YEAR", 5) + "|");

        for (Book book : BookCollection.collection) {
            if (book.isAvailable()){
                System.out.println("| " +
                        stringWithExtraCharacters(book.getTitle(), 40) + "| " +
                        stringWithExtraCharacters(book.getAuthor(), 40) + "| " +
                        stringWithExtraCharacters(String.valueOf(book.getYear()), 5)+ "|");
            }
        }
    }

    public static String stringWithExtraCharacters(String string, int length) {
        return String.format("%1$-"+length+ "s", string);
    }

    public static Book search(String userSearch) {
        for (Book book : BookCollection.collection) {
            if (userSearch.equalsIgnoreCase(book.getTitle()))
                return book;
        }
        System.out.println("Book not found...");
        return null;
    }
}
