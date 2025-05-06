package com.example.spring_learning.multi_threading;

public class Transaction {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(3000); // Initial balance ₹3000

        Thread withdraw1 = new Thread(new WithdrawTask(account, "Alice", 5000));
        Thread withdraw2 = new Thread(new WithdrawTask(account, "Bob", 2000));
        Thread deposit1 = new Thread(new DepositTask(account, "Charlie", 4000));

        withdraw1.start(); // Alice tries to withdraw ₹5000 (should wait)
        withdraw2.start(); // Bob withdraws ₹2000 (should succeed)

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getCause().toString());
        } // Simulate delay before deposit
        deposit1.start();
    }
}
