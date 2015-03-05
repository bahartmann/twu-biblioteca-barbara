package com.twu.biblioteca.commands;

import com.twu.biblioteca.lib.Command;
import com.twu.biblioteca.models.MovieCollection;

/**
 * Created by bhartman on 3/5/15.
 */
public class ListMoviesCommand implements Command{
    public String describe() {
        return "Show a list of available library movies";
    }

    public void run() {
        MovieCollection movieCollection = MovieCollection.getInstance();
        movieCollection.printMoviesTable();
    }
}
