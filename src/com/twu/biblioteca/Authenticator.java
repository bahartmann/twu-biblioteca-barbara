package com.twu.biblioteca;

import com.twu.biblioteca.models.UserAccount;

import java.util.ArrayList;

/**
 * Created by bhartman on 3/5/15.
 */
public class Authenticator {

    private static Authenticator instance;

    public static synchronized Authenticator getInstance(){
        if (instance == null)
            instance = new Authenticator();
        return instance;
    }

    private Authenticator(){};

    private UserAccount currentLoggedUser;
    public ArrayList<UserAccount> userList = new ArrayList<UserAccount>();

    public UserAccount getCurrentLoggedUser() {
        return currentLoggedUser;
    }

    private void setCurrentLoggedUser(UserAccount currentLoggedUser) {
        this.currentLoggedUser = currentLoggedUser;
    }

    public void authenticateUser(String libraryNumber, String password){
        for (UserAccount usr : userList){
            if (libraryNumber == usr.getLibraryNumber() && password == usr.getPassword()) {
                setCurrentLoggedUser(usr);
                System.out.println("Successful login!");
                return;
            }
        }
        System.out.println("Invalid credential!");
    }

    public void logOut(){
        setCurrentLoggedUser(null);
        System.out.println("Successful logout!");
    }

}
