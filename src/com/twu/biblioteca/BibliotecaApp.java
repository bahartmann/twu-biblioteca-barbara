package com.twu.biblioteca;

import java.io.IOException;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        welcomeMessage();
        menu(true);
    }

    private static void menu(boolean keepRunning) {
        Scanner reader = new Scanner(System.in);

        while(keepRunning){
            System.out.println("\nWhat would you like to do? \n" +
                    "[1] List books \n" +
                    "[2] Check-out book \n" +
                    "[3] Return book \n" +
                    "[0] Quit");
            int selectedOption = reader.nextInt();
            switch (selectedOption) {
                case 0:
                    keepRunning = false;
                    break;
                case 1:
                    BookCollection.printBooksTable();
                    break;
                case 2:
                    checkOutBook();
                    break;
                case 3:
                    returnBook();
                    break;
                default:
                    System.out.println("Select a valid option!");
                    break;
            }
        }
    }

    private static void checkOutBook() {
        Book book = searchBook("What book would you like check-out?");
        if (book != null) {
            book.checkout();
        }
    }

    private static void returnBook() {
        Book book = searchBook("What book would you like return?");
        if (book != null) {
            book.returning();
        }
    }

    private static Book searchBook(String prompt) {
        Scanner reader = new Scanner(System.in);

        System.out.println(prompt);
        String userSearch = reader.nextLine();
        Book book = null;

        while (book == null && !userSearch.equalsIgnoreCase("Q")) {
            book = BookCollection.search(userSearch);
            System.out.println("Try again! (Press Q to quit)");
            userSearch = reader.nextLine();
        }

        return book;
    }

    private static void welcomeMessage() {
        System.out.println("-- -- -- Welcome to Biblioteca! -- -- --");
    }
}
