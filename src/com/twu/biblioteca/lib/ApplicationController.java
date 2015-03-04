package com.twu.biblioteca.lib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by bhartman on 3/3/15.
 */
public class ApplicationController {

    private static Map<String, Command> menuOptions = new HashMap<String,Command>();

    public void defineMenuOption(String commandName, Command commandClass) {
        menuOptions.put(commandName, commandClass);
    }

    public void printCommandHelp() {
        Iterator it = menuOptions.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + " - " + ((Command)pair.getValue()).describe());
        }
    }

    public void waitForUserInput() {
        Scanner reader = new Scanner(System.in);

        do {
            System.out.println("\nType a command");
            String userInput = reader.nextLine();
            executeCommand(userInput);
        } while (true);
    }

    private void executeCommand(String commandName) {

        if (menuOptions.containsKey(commandName)) {
            Command command = menuOptions.get(commandName);
            command.run();
        } else {
            System.out.println("Select a valid option!");
        }
    }

}
