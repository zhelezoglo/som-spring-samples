package com.som.tkach.threads;

/**
 * @author som
 */
public class Account {

    private volatile int balance;

    public Account(int initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(int amount){
        System.out.println("INSIDE withdraw BEFORE. BALANCE = " + balance + "; AMOUNT = " + amount);
        balance -= amount;
        System.out.println("INSIDE withdraw AFTER. BALANCE = " + balance + "; AMOUNT = " + amount);
    }

    public void deposit(int amount){
        System.out.println("INSIDE deposit BEFORE. BALANCE = " + balance + "; AMOUNT = " + amount);
        balance += amount;
        System.out.println("INSIDE deposit AFTER. BALANCE = " + balance + "; AMOUNT = " + amount);
    }

    public int getBalance() {
        return balance;
    }
}
