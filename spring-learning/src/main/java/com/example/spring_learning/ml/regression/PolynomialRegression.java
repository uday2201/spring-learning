package com.example.spring_learning.ml.regression;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

public class PolynomialRegression {

  /**
   * Polynomial Regression Example
   * This example demonstrates polynomial regression using the least squares method.
   * It predicts house prices based on size and a polynomial degree.
   */
  public static double[][] expandPolynomialFeatures(double[] x, int degree) {
    double[][] result = new double[x.length][degree];
    for (int i = 0; i < x.length; i++) {
      for (int j = 1; j <= degree; j++) {
        result[i][j - 1] = Math.pow(x[i], j);
      }
    }
    return result;
  }

  /**
   * Polynomial Regression Example
   * This example demonstrates polynomial regression using the least squares method.
   * It predicts house prices based on size and a polynomial degree.
   */
  public static void main(String[] args) {
    // x: sizes
    double[] x = {1000, 1100, 1200, 1300, 1400};
    // y: prices
    double[] y = {150, 180, 210, 250, 320};

    // Expand to polynomial degree 2 (x and x^2)
    double[][] polynomial = expandPolynomialFeatures(x, 2);

    // Train the model
    OLSMultipleLinearRegression regression = new OLSMultipleLinearRegression();
    regression.newSampleData(y, polynomial);
    double[] coefficients = regression.estimateRegressionParameters();

    System.out.printf("Model: y = %.2f + %.4f*x + %.6f*x^2\n", coefficients[0], coefficients[1], coefficients[2]);

    // Predict price for 1250 sq ft house
    double size = 1250;
    double predictedPrice = coefficients[0] + coefficients[1] * size + coefficients[2] * size * size;

    System.out.printf("Predicted Price for %.0f sq ft house: $%.2fK\n", size, predictedPrice);
  }
}
