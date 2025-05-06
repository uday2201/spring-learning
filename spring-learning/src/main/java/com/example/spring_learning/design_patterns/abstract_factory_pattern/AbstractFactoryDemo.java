package com.example.spring_learning.design_patterns.abstract_factory_pattern;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        // Assume we detect the OS type dynamically (hardcoded for demo)
        String osType = "Mac";

        // Get the factory for the given OS
        GUIFactory factory = FactoryProducer.getFactory(osType);

        // Create UI components
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        // Render UI components
        button.render();  // Output: Rendering Mac Button
        checkbox.render();  // Output: Rendering Mac Checkbox
    }
}
