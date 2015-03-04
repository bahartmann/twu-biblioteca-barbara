package com.twu.biblioteca.commands;

import com.twu.biblioteca.lib.Command;

/**
 * Created by bhartman on 3/3/15.
 */
public class ExitCommand implements Command {

    public String describe() {
        return "Exit from the application";
    }

    public void run() {
        System.out.println("Come back soon!");
        System.exit(0);
    }
}
