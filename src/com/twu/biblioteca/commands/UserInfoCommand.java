package com.twu.biblioteca.commands;

import com.twu.biblioteca.Authenticator;
import com.twu.biblioteca.lib.Command;
import com.twu.biblioteca.models.UserAccount;

/**
 * Created by bhartman on 3/5/15.
 */
public class UserInfoCommand implements Command {
    public String describe() {
        return "Checks-out the selected book";
    }

    public void run() {
        UserAccount currentUser = Authenticator.getInstance().getCurrentLoggedUser();
        if (currentUser == null){
            System.out.println("You have to login to see your information!");
            return;
        }

        currentUser.printInfo();
    }
}
