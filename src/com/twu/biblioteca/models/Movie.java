package com.twu.biblioteca.models;

/**
 * Created by bhartman on 3/4/15.
 */
public class Movie extends LibraryItem {
    private int year;
    private String director;
    private double rating;

    public int getYear() {
        return year;
    }
    public String getDirector() {
        return director;
    }
    public double getRating() {
        return rating;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public void setDirector(String author) {
        this.director = author;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }

    public Movie(String title, String director, int year, double rating) {
        setTitle(title);
        setDirector(director);
        setYear(year);
        setRating(rating);
        setCheckedOut(false);
    }

    public void checkout(UserAccount currentUser) {
        String checkoutStatus = checkoutItem(currentUser) ? "Thank you! Enjoy the movie"
                : "That movie is not available.";
        System.out.println(checkoutStatus);
    }

}
