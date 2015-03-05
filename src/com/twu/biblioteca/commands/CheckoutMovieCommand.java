package com.twu.biblioteca.commands;

import com.twu.biblioteca.lib.Command;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.BookCollection;
import com.twu.biblioteca.models.Movie;
import com.twu.biblioteca.models.MovieCollection;

import java.util.Scanner;

/**
 * Created by bhartman on 3/5/15.
 */
public class CheckoutMovieCommand implements Command {
    public String describe() {
        return "Checks-out the selected book";
    }

    public void run() {
        MovieCollection movieCollection = MovieCollection.getInstance();

        System.out.println("What movie would you like check-out?");
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine();

        Movie movie = movieCollection.searchMovie(userInput);

        if (movie != null) {
            movie.checkout();
        }
    }
}
