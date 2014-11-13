package com.som.stuff.exceptions2;

import com.som.stuff.exceptions.MyResource;

import java.io.IOException;

/**
 * @author som
 */
public class SuppressedException2 {
    static MyResource getNullInputStream() {
        throw new RuntimeException();
//        return new MyResource();
    }

    static String calculate() throws IOException {
        try {
            String s = null;
            s.equals(2);
//            return s;
            return s;
        } catch (NullPointerException e) {
            System.out.println("catch");
//            return "catch2";
            throw new ArrayIndexOutOfBoundsException();
        } finally {
            String s = null;
            s.equals(2);
            return "finally";
        }
//        return "end";
    }

    public static void main(String[] args) {
        try {
            String result = calculate();
            System.out.println("result = " + result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("" + e.getSuppressed().length);
        }

    }
}
