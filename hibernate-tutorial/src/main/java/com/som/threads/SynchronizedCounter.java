package com.som.threads;

public class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " inside method");
        Thread.sleep(10000);
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
}