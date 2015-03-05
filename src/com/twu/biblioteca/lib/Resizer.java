package com.twu.biblioteca.lib;

/**
 * Created by bhartman on 3/4/15.
 */
public class Resizer {

    public Resizer() {}

    public String addCharacters(Object string, Object length) {
        String str = String.format("%1$-"+length+ "s", string);
        str += "| ";
        return str;
    }
}