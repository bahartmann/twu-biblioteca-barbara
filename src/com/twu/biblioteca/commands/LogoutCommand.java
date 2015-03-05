package com.twu.biblioteca.commands;

import com.twu.biblioteca.Authenticator;

/**
 * Created by bhartman on 3/5/15.
 */
public class LogoutCommand {
    public String describe() {
        return "Exit user session";
    }

    public void run() {
        Authenticator.getInstance().logOut();
    }
}
