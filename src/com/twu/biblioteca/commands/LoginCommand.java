package com.twu.biblioteca.commands;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.lib.Command;

import java.util.Scanner;

/**
 * Created by bhartman on 3/5/15.
 */
public class LoginCommand implements Command {

    public String describe() {
        return "Authenticate user";
    }

    public void run() {
        Scanner reader = new Scanner(System.in);

        System.out.println("What's your library number?");
        String userNumber = reader.nextLine();
        System.out.println("What's your pasword?");
        String userPassword = reader.nextLine();

        Authenticator.getInstance().authenticateUser(userNumber, userPassword);
    }
}
