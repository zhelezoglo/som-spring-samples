package com.som.threads;

/**
 * @author som
 */
public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from thread!");
    }

    public static void main(String[] args) {

        (new Thread(new HelloRunnable())).start(); // from other thread
        new HelloRunnable().run(); // in the current thread
    }
}
