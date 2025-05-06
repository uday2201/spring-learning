package com.example.spring_learning.design_patterns.abstract_factory_pattern;

// Windows-specific Button implementation
public class MacButton implements Button {
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}
