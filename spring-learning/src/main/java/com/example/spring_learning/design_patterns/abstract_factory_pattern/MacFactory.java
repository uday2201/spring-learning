package com.example.spring_learning.design_patterns.abstract_factory_pattern;

public class MacFactory implements GUIFactory {
    public Button createButton() {
        return new MacButton();
    }

    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
