package com.example.spring_learning.payment;

import org.springframework.stereotype.Service;

@Service
public class Payment {
    public void processPayment() {
        System.out.println("Payment processed");
    }
}
