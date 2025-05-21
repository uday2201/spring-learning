package com.example.spring_learning.ml.regression;


public class LinearRegression_HousePricing {

  /**
   * Simple Linear Regression Example for House Pricing
   * This example predicts house prices based on size using the least squares method.
   */
  public static void main(String[] args) {
    // Sample data: size in square feet (x) and price in thousands (y)
    double[] x = {1000, 1500, 2000, 2500, 3000}; // size
    double[] y = {200, 250, 300, 350, 400};      // price in thousands

    int n = x.length;

    // Step 1: Calculate means
    double sumX = 0;
    double sumY = 0;
    for (int i = 0; i < n; i++) {
      sumX += x[i];
      sumY += y[i];
    }
    double meanX = sumX / n;
    double meanY = sumY / n;

    // Step 2: Calculate slope (m) and intercept (c)
    double numerator = 0;
    double denominator = 0;
    for (int i = 0; i < n; i++) {
      numerator += (x[i] - meanX) * (y[i] - meanY);
      denominator += (x[i] - meanX) * (x[i] - meanX);
    }

    double m = numerator / denominator; // least square method which is used to find the slope in case of multiple inputs
    double c = meanY - m * meanX;

    System.out.printf("Linear Regression Equation: y = %.2fx + %.2f%n", m, c);

    // Predict the price for a 2200 sq ft house
    double size = 2200;
    double predictedPrice = m * size + c;

    System.out.printf("Predicted price for %.0f sq ft house: $%.2fK%n", size, predictedPrice);
    }
}
