package com.som.blog.util;

/**
 * @author som
 */
// TODO: replace with Spring Utils
public final class CheckNotEmpty {

    private CheckNotEmpty() {
    }

    static public void throwIllegalArgument(String name, String arg) {
        if (arg.isEmpty()) throw new IllegalArgumentException(name + " cannot be empty");
    }
}
