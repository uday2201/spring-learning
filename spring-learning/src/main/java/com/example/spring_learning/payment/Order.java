package com.example.spring_learning.payment;

import org.springframework.stereotype.Service;

@Service
public class Order {
    public void createOrder() {
        System.out.println("Order is created, please reserve the inventory");
    }

    public void cancelOrder() {
        System.out.println("Order is being cancelled, as the payment is failed");
    }
}
