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

    private String name;
    private String email;
    private String phone;

    public String getLibraryNumber() {
        return libraryNumber;
    }
    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
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

    public void printInfo() {
        System.out.println("Library number: " + this.getLibraryNumber() +
                "Name: " + this.getName() +
                "E-mail: " + this.getEmail() +
                "Phone number: " + this.getPhone());
    }
}
