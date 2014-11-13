package com.som.tkach.threads;


public class Operations {

    public static void main(String[] args) {
        final Account a = new Account(1000);
        final Account b = new Account(2000);



        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("BEFORE transfer");
                    transfer(a, b, 500);
                    System.out.println("AFTER transfer");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("BEFORE transfer");
                    transfer(b, a, 300);
                    System.out.println("AFTER transfer");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

//        thread1.run();
//        thread2.run();
        thread1.start();
        thread2.start();

    }


    static void transfer(Account srcAcc, Account dstAcc, int amount) throws InsufficientFundsException, InterruptedException {
        synchronized (srcAcc){
            System.out.println("OUTER lock obtained");
            Thread.sleep(1000L);
            synchronized (dstAcc) {
                System.out.println("INNER lock obtained");
                if (srcAcc.getBalance() < amount) {
                    throw new InsufficientFundsException();
                }

                srcAcc.withdraw(amount);
                dstAcc.deposit(amount);
            }
            System.out.println("INNER lock released");
        }
        System.out.println("OUTER lock released");
    }
}
