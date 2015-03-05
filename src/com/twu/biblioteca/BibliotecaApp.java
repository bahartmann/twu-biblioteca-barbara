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

        app.defineMenuOption("Login", new LoginCommand());
        app.defineMenuOption("Logout", new LoginCommand());

        app.defineMenuOption("List Books", new ListBooksCommand());
        app.defineMenuOption("Check-out Book", new CheckoutBookCommand());
        app.defineMenuOption("Return Book", new ReturnBookCommand());

        app.defineMenuOption("List Movies", new ListMoviesCommand());
        app.defineMenuOption("Check-out Movie", new CheckoutMovieCommand());

        app.defineMenuOption("Exit", new ExitCommand());
        app.printCommandHelp();
        app.waitForUserInput();
    }

    private static void welcomeMessage() {
        System.out.println("-- -- -- Welcome to Biblioteca! -- -- --");
    }
}
