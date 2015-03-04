package com.twu.biblioteca.models;

/**
 * Created by bhartman on 3/4/15.
 */
public class LibraryItem {
    private String title;
    private boolean checkedOut;

    public String getTitle() {
        return title;
    }
    public boolean isAvailable() {
        return !checkedOut;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public boolean checkoutItem() {
        if (this.isAvailable()) {
            setCheckedOut(true);
            return true;
        }
        return false;
    }

    public boolean returnItem() {
        if (this.isAvailable()) {
            return false;
        }
        setCheckedOut(false);
        return true;
    }
}
