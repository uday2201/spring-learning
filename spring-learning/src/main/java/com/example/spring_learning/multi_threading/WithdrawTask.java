package com.example.spring_learning.multi_threading;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WithdrawTask implements Runnable {
    private BankAccount bankAccount = new BankAccount();
    private String user;
    private int amount;


    @Override
    public void run() {
        bankAccount.withDraw(user, amount);
    }
}
