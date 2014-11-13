package com.som.threads;

/**
 * @author som
 */
public class Main2 {

    static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                    try {
                        counter.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    counter.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        thread2.start();
        thread.join();
    }
}
