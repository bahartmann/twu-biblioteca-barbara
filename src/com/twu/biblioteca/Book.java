package com.twu.biblioteca;

import sun.tools.asm.ArrayData;

import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private int year;
    private boolean checkedOut;

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }
    public boolean isAvailable() {
        return !checkedOut;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public Book(String title, String author, int year, boolean checkedOut) {
        setTitle(title);
        setAuthor(author);
        setYear(year);
        setCheckedOut(checkedOut);
        BookCollection.add(this);
    }

    public boolean checkout() {
        if (this.isAvailable()) {
            setCheckedOut(true);
            return true;
        }
        return false;
    }

    public String[] getData() {
        String bookYear = String.valueOf(this.getYear());

        String bookAvailability = "Unavailable";
        if (this.isAvailable()) bookAvailability = "Available";

        return new String[]{this.getTitle(), this.getAuthor(),  bookYear, bookAvailability};
    }

}