package com.twu.biblioteca.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhartman on 3/5/15.
 */
public class UserAccount {

    private String libraryNumber;
    private String password;
    private List<UserAccount> userCollection = new ArrayList<UserAccount>();

    public String getLibraryNumber() {
        return libraryNumber;
    }
    public String getPassword() {
        return password;
    }

    public void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAccount(String libraryNumber, String password) {
        setLibraryNumber(libraryNumber);
        setPassword(password);
    }
}
