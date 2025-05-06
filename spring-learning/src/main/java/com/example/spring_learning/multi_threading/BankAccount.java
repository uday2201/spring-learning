package com.example.spring_learning.multi_threading;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BankAccount {
    private int balance;

    protected synchronized void withDraw(String user, int amount) {
        System.out.println(user + " wants to withdraw ₹" + amount);
        while (amount > balance) { // Use while to prevent spurious wake-ups
          System.out.println("❌ Insufficient balance for " + user + ". Waiting for deposit...");
          try {
            wait(); // Wait until deposit happens
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        }

        balance -= amount;
        System.out.println(user + " successfully withdrew ₹" + amount);
        System.out.println("💰 Remaining Balance: ₹" + balance);
    }

    // Synchronized method for deposit
    protected synchronized void deposit(String user, int amount) {
        System.out.println(user + " deposited ₹" + amount);
        balance += amount;
        System.out.println("💰 Updated Balance: ₹" + balance);
        notifyAll(); // Notify all waiting withdrawal threads
    }
}
