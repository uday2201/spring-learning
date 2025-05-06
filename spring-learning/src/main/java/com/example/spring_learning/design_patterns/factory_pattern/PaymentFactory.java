package com.example.spring_learning.design_patterns.factory_pattern;

public class PaymentFactory {
    // Factory method to return different shapes
    public PaymentProcessor getPayment(String payType) {
        if (payType == null) {
            return null;
        }
        return switch (payType.toLowerCase()) {
            case "paypal" -> new PaymentProcessors.Paypal();
            case "credit-card" -> new PaymentProcessors.CreditCard();
            case "upi" -> new PaymentProcessors.UPI();
            default -> throw new IllegalArgumentException("Invalid payment type");
        };
    }
}
