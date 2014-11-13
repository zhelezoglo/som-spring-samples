package com.som.oracle;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class ExceptionSample {

    public static void canThrowExceptions() throws ParseException, IOException {
        throw new ParseException("", 5);
    }

    public static void main(String[] args) throws ParseException, IOException, SQLException {
        try {
            canThrowExceptions();
        } catch (ParseException | IOException checkedException) {
            checkedException.printStackTrace();
//            checkedException = new IOException("");
            throw checkedException;
        }
    }

}