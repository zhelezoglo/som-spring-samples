package com.som.stuff.exceptions;

import java.io.IOException;

/**
 * @author som
 */
public class SuppressedException {
    static MyResource getNullInputStream() {
        throw new RuntimeException();
//        return new MyResource();
    }

    static void create() throws IOException {
        try (MyResource myResource = getNullInputStream()) {
//         inputStream.available();
            throw new ArrayIndexOutOfBoundsException();

        }
    }

    public static void main(String[] args) {
        try {
            create();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("" + e.getSuppressed().length);
        }

    }
}
