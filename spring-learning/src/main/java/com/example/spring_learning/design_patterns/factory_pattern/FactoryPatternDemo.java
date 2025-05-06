package com.example.spring_learning.design_patterns.factory_pattern;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        PaymentFactory paymentFactory = new PaymentFactory();

        // Get a CC and pay it
        PaymentProcessor shape1 = paymentFactory.getPayment("credit-card");
        shape1.processPayment(200.0);

        // Get a paypal and pay it
        PaymentProcessor shape2 = paymentFactory.getPayment("UPI");
        shape2.processPayment(300.00);

        // Get a UPI and pay it
        PaymentProcessor shape3 = paymentFactory.getPayment("Paypal");
        shape3.processPayment(100.00);
    }
}
