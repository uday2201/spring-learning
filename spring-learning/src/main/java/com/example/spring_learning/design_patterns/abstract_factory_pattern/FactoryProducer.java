package com.example.spring_learning.design_patterns.abstract_factory_pattern;

import com.example.spring_learning.design_patterns.factory_pattern.PaymentProcessors;

public class FactoryProducer {

    public static GUIFactory getFactory(String osType) {
        if (osType.isEmpty()) {
            return null;
        }
        return switch (osType.toLowerCase()) {
            case "windows" -> new WindowsFactory();
            case "mac" -> new MacFactory();
            default -> throw new IllegalArgumentException("Invalid OS type");
        };
    }
}
