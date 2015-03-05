package com.twu.biblioteca;

import com.twu.biblioteca.commands.*;
import com.twu.biblioteca.lib.ApplicationController;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.BookCollection;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.MovieCollection;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        welcomeMessage();

        ApplicationController app = new ApplicationController();

        BookCollection collectionOne = BookCollection.getInstance();
        collectionOne.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925, false));
        collectionOne.addBook(new Book("Head First Java", "Bert Bates and Kathy Sierra", 2004, false));
        collectionOne.addBook(new Book("The Grapes of Wrath", "John Steinbeck", 1939, true));

        MovieCollection collectionM = MovieCollection.getInstance();
        collectionM.addMovie(new Movie("Casablanca", "Michael Curtiz", 1942, 8));
        collectionM.addMovie(new Movie("Pulp Fiction", "Quentin Tarantino", 1994, 8.8));
        collectionM.addMovie(new Movie("The Good, the Bad and the Ugly", "Sergio Leone", 1966, 8.9));

        app.defineMenuOption("List Books", new ListBooksCommand());
        app.defineMenuOption("List Movies", new ListMoviesCommand());
        app.defineMenuOption("Check-out Book", new CheckoutBookCommand());
        app.defineMenuOption("Return Book", new ReturnBookCommand());
        app.defineMenuOption("Exit", new ExitCommand());
        app.printCommandHelp();
        app.waitForUserInput();
    }

    private static void welcomeMessage() {
        System.out.println("-- -- -- Welcome to Biblioteca! -- -- --");
    }
}
