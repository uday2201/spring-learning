package com.example.spring_learning.payment;

import org.springframework.stereotype.Service;

@Service
public class Inventory {
    public void reserveInventory() {
        System.out.println("Inventory is reserved, please proceed the payment");
    }
    public void releaseInventory() {
        System.out.println("Inventory is being released, as the payment is failed");
    }
}
