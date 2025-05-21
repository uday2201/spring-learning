package com.example.spring_learning.ml.classification;

import smile.classification.SVM;
import smile.math.kernel.GaussianKernel;

public class SVMExample {
  /**
   * Support Vector Machine (SVM) Example
   * This example demonstrates a simple SVM for binary classification.
   * The model predicts whether a person is fit or overweight based on height and weight.
   */
  public static void main(String[] args) {
    // Features: [height, weight]
    double[][] x = {
            {170, 65}, {180, 80}, {160, 50}, // Class 0
            {170, 90}, {185, 100}, {175, 95} // Class 1
    };

    // Labels: 0 = fit, 1 = overweight
    double[] y = {0, 0, 0, 1, 1, 1};

    // Create SVM model with a linear kernel
    SVM<double[]> svm = new SVM<>(new GaussianKernel(0.5), x, y, 10.0);

    // Predict
    int prediction = svm.predict(new double[]{172, 72});
    System.out.println("Prediction: " + (prediction == 0 ? "Fit" : "Overweight"));
 }
}
