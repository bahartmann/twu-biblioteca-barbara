package com.twu.biblioteca.commands;
import com.twu.biblioteca.models.BookCollection;
import com.twu.biblioteca.lib.Command;

/**
 * Created by bhartman on 3/3/15.
 */
public class ListBooksCommand implements Command {
    public String describe() {
        return "Show a list of all library books";
    }


    public void run() {
        BookCollection bookCollection = BookCollection.getInstance();
        bookCollection.printBooksTable();
    }
}
