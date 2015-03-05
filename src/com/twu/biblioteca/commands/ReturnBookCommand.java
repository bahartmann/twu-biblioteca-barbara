package com.twu.biblioteca.commands;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.lib.Command;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.BookCollection;

import java.util.Scanner;

/**
 * Created by bhartman on 3/4/15.
 */
public class ReturnBookCommand implements Command {
    public String describe() {
        return "Returns the selected book";
    }

    public void run() {
        if (Authenticator.getInstance().getCurrentLoggedUser() == null){
            System.out.println("You have to login to return a book!");
            return;
        }
        BookCollection bookCollection = BookCollection.getInstance();

        System.out.println("What book would you like return?");
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine();

        Book book = bookCollection.searchBook(userInput);

        if (book != null) {
            book.returning();
        }
    }
}
