package com.example.spring_learning.design_patterns.factory_pattern;

public class PaymentProcessors {
    static class CreditCard implements PaymentProcessor {
        public void processPayment(double amount) {
            System.out.println("Paying via CC: of amount " + amount);
        }
    }

    static class Paypal implements PaymentProcessor {
        public void processPayment(double amount) {
            System.out.println("Paying via Paypal: of amount " + amount);
        }
    }

    static class UPI implements PaymentProcessor {
        public void processPayment(double amount) {
            System.out.println("Paying via UPI: of amount " + amount);
        }
    }
}
