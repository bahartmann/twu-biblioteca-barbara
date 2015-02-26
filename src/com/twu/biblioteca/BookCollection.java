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
                stringWithExtraCharacters("YEAR", 5) + "| " +
                stringWithExtraCharacters("AVAILABILITY", 13) + "|");

        for (Book book : BookCollection.collection) {
            System.out.println("| " +
                    stringWithExtraCharacters(book.getData()[0], 40) + "| " +
                    stringWithExtraCharacters(book.getData()[1], 40) + "| " +
                    stringWithExtraCharacters(book.getData()[2], 5)+ "| " +
                    stringWithExtraCharacters(book.getData()[3], 13) + "|");
        }
    }

    public static String stringWithExtraCharacters(String string, int length) {
        return String.format("%1$-"+length+ "s", string);
    }
}
