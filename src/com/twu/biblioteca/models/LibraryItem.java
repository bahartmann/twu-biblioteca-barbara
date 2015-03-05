package com.twu.biblioteca.models;

/**
 * Created by bhartman on 3/4/15.
 */
public class LibraryItem {
    private String title;
    private boolean checkedOut;
    private UserAccount checkedBy;

    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return !checkedOut;
    }
    public UserAccount getCheckedBy() { return checkedBy; }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
    public void setUser(UserAccount user) {
        this.checkedBy = user;
    }

    public boolean checkoutItem(UserAccount currentUser) {
        if (this.isAvailable()) {
            setUser(currentUser);
            setCheckedOut(true);
            return true;
        }
        return false;
    }

    public boolean returnItem() {
        if (this.isAvailable()) {
            return false;
        }
        setUser(null);
        setCheckedOut(false);
        return true;
    }
}
