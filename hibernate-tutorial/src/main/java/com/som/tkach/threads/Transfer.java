package com.som.tkach.threads;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author som
 */
public class Transfer implements Callable<Boolean> {

    private final Account from;
    private final Account to;
    private final int amount;

    public Transfer(final Account from, final Account to, int amount) {
       this.from = from;
       this.to = to;
       this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
        from.withdraw(amount);
        to.deposit(amount);
        return null;  // TODO: Implement
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Account account1 = new Account(1000);
        Account account2 = new Account(1000);
        Random random = new Random(12345L);

        for (int i = 0; i<10; i++){
            executorService.submit(new Transfer(account1, account2, random.nextInt(50)));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();  // TODO
        }
    }
}
