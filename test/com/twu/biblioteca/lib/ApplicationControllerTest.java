package com.twu.biblioteca.lib;

import com.twu.biblioteca.commands.ListBooksCommand;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ApplicationControllerTest {

    private ApplicationController appController = new ApplicationController();
    private Map<String, Command> menuOptions;
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        menuOptions = new HashMap<String,Command>();
        menuOptions.put("Print something", new ListBooksCommand());
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void shouldPrintDefinedMenuOptions() {
        appController.defineMenuOption("Do something", new DoSomethingCommand());
        appController.printCommandHelp();
        assertEquals("Do something - This command do something\n", outContent.toString());
    }

}

class DoSomethingCommand implements Command {
    public String describe() {
        return "This command do something";
    }
    public void run() {}
}