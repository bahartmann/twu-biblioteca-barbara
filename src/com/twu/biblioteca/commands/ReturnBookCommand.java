package com.twu.biblioteca.commands;

import com.twu.biblioteca.lib.Command;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.BookCollection;

/**
 * Created by bhartman on 3/4/15.
 */
public class ReturnBookCommand implements Command {
    public String describe() {
        return "Returns the selected book";
    }

    public void run() {
        BookCollection bookCollection = BookCollection.getInstance();
        Book book = bookCollection.searchBook("What book would you like return?");

        if (book != null) {
            book.returning();
        }
    }
}
