package com.som.threads;

/**
 * @author som
 */
public class Main {

    static SynchronizedCounter counter = new SynchronizedCounter();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
//                        Thread.sleep(1000);
                        counter.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("counter.value() = " + counter.value());
                }
            }
        });

        thread.start();
        thread2.start();
        thread.join();
    }
}
