package com.twu.biblioteca.commands;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.lib.Command;
import com.twu.biblioteca.models.Book;
import com.twu.biblioteca.models.BookCollection;
import com.twu.biblioteca.models.UserAccount;

import java.util.Scanner;

/**
 * Created by bhartman on 3/3/15.
 */
public class CheckoutBookCommand implements Command {

    public String describe() {
        return "Checks-out the selected book";
    }

    public void run() {
        UserAccount currentUser = Authenticator.getInstance().getCurrentLoggedUser();
        if (currentUser == null){
            System.out.println("You have to login to check-out a book!");
            return;
        }
        BookCollection bookCollection = BookCollection.getInstance();

        System.out.println("What book would you like check-out?");
        Scanner reader = new Scanner(System.in);
        String userInput = reader.nextLine();

        Book book = bookCollection.searchBook(userInput);

        if (book != null) {
            book.checkout(currentUser);
        }
    }
}
