package com.twu.biblioteca.models;

public class Book extends LibraryItem {
    private String author;
    private int year;

    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public Book(String title, String author, int year, boolean checkedOut) {
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setCheckedOut(checkedOut);
    }

    public void checkout() {
        String checkoutStatus = checkoutItem() ? "Thank you! Enjoy the book"
                : "That book is not available.";
        System.out.println(checkoutStatus);
    }

    public void returning() {
        String returnStatus = returnItem() ? "Thank you for returning the book."
                : "That is not a valid book to return.";
        System.out.println(returnStatus);
    }
}