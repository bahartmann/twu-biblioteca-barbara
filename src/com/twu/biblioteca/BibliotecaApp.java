package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        welcomeMessage();
        BookCollection.printBooksTable();
    }

    private static void welcomeMessage() {
        System.out.println("-- -- -- Welcome to Biblioteca! -- -- --");
    }
}
