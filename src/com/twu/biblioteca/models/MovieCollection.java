package com.twu.biblioteca.models;

import com.twu.biblioteca.lib.Resizer;

import java.util.ArrayList;
import java.util.List;

public class MovieCollection {

    private static MovieCollection instance;

    public static synchronized MovieCollection getInstance(){
        if (instance == null)
            instance = new MovieCollection();
        return instance;
    }

    private MovieCollection(){};

    private static List<Movie> collection = new ArrayList<Movie>();

    public void addMovie(Movie movie) {
        collection.add(movie);
    }

    public void printMoviesTable() {
        Resizer resizer = new Resizer();

        System.out.println("| " +
                resizer.addCharacters("TITLE", 40) +
                resizer.addCharacters("DIRECTOR", 40) +
                resizer.addCharacters("YEAR", 5) +
                resizer.addCharacters("RATING", 8));

        for (Movie movie : this.collection) {
            if (movie.isAvailable()){
                System.out.println("| " +
                        resizer.addCharacters(movie.getTitle(), 40) +
                        resizer.addCharacters(movie.getDirector(), 40) +
                        resizer.addCharacters(String.valueOf(movie.getYear()), 5) +
                        resizer.addCharacters(Double.toString(movie.getRating()), 8));
            }
        }
    }

    public Movie searchMovie(String userSearch) {
        for (Movie movie : this.collection) {
            if (userSearch.equalsIgnoreCase(movie.getTitle()))
                return movie;
        }
        System.out.println("Movie not found.");
        return null;
    }

    private static String stringWithExtraCharacters(String string, int length) {
        return String.format("%1$-"+length+ "s", string);
    }
}
