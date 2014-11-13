package com.som.threads;

/**
 * @author som
 */
public class SleepMessages implements Runnable {
    String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
    };

    public static void main(String args[]) throws InterruptedException {
        Thread thread = new Thread(new SleepMessages());
        thread.start();
        thread.join(10000);
//        Thread.sleep(5000);
        thread.interrupt();
    }

    @Override
    public void run() {
        for (String anImportantInfo : importantInfo) {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                System.out.println("Child Thread Interrupted");
                e.printStackTrace();
                return;
            }
            System.out.println(anImportantInfo);
        }

    }
}
