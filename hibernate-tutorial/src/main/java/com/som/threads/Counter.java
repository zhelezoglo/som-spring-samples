package com.som.threads;

/**
 * @author som
 */
public class Counter {
    private int c = 0;

    public void increment() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " inside method");
        Thread.sleep(10000);
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return c;
    }


}
