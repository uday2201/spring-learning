package com.example.spring_learning.ml.regression;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

public class MultipleLinearRegressionExample {
  /**
   * This example demonstrates how to perform multiple linear regression using Apache Commons Math.
   * The model predicts house prices based on features like size, number of bedrooms, and age.
   */
  public static void main(String[] args) {
    // X: Features (size, bedrooms, age)
    double[][] x = {
      {1500, 3, 20},
      {1600, 3, 15},
      {1700, 4, 10},
      {1800, 4, 5},
      {1900, 5, 2}
    };

    // y: Output (Price)
    double[] y = {300, 320, 340, 360, 380};

    // Step 1: Create model
    OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
    regression.newSampleData(y, x); // y then X

    // Step 2: Get coefficients
    double[] coefficients = regression.estimateRegressionParameters();

    System.out.printf("Regression Equation: y = %.2f + %.2f*size + %.2f*bedrooms + %.2f*age%n",
          coefficients[0], coefficients[1], coefficients[2], coefficients[3]);

    // Step 3: Predict price for a new house
    double size = 1750;
    double bedrooms = 3;
    double age = 8;

    double predictedPrice = coefficients[0] + coefficients[1] * size + coefficients[2] * bedrooms
        + coefficients[3] * age;

    System.out.printf("Predicted Price for house: $%.2fK%n", predictedPrice);
  }
}

