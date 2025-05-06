package com.example.spring_learning.design_patterns.abstract_factory_pattern;

// Windows-specific Button implementation
public class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}
