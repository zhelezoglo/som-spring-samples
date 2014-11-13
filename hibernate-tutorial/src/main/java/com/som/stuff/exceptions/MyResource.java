package com.som.stuff.exceptions;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author som
 */
public class MyResource implements Closeable {
    /**
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this
     * method has no effect.
     *
     * @throws java.io.IOException if an I/O error occurs
     */
    @Override
    public void close() throws IOException {
        System.out.println("Inside close\n");
        throw new NullPointerException();
    }
}
