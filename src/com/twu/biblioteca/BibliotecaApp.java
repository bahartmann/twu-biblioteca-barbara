package com.twu.biblioteca;

import com.twu.biblioteca.commands.CheckoutBookCommand;
import com.twu.biblioteca.commands.ExitCommand;
import com.twu.biblioteca.commands.ListBooksCommand;
import com.twu.biblioteca.commands.ReturnBookCommand;
import com.twu.biblioteca.lib.ApplicationController;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.BookCollection;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        welcomeMessage();

        ApplicationController app = new ApplicationController();

        app.defineMenuOption("List Books", new ListBooksCommand());
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
