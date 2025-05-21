package com.example.spring_learning.ml.regression;

public class LinearRegressionGD {
    private double w; // weight (slope)
    private double b; // bias (intercept)
    private final double learningRate;
    private final int epochs;

    public LinearRegressionGD(double learningRate, int epochs) {
        this.learningRate = learningRate;
        this.epochs = epochs;
        this.w = 0;
        this.b = 0;
    }

    public void fit(double[] X, double[] y) {
        int m = X.length;

        for (int epoch = 0; epoch < epochs; epoch++) {
            double[] yPred = predict(X);

            // Calculate gradients
            double dw = 0;
            double db = 0;

            for (int i = 0; i < m; i++) {
                dw += (yPred[i] - y[i]) * X[i];
                db += (yPred[i] - y[i]);
            }
            dw /= m;
            db /= m;

            // Update parameters
            w -= learningRate * dw;
            b -= learningRate * db;

            // Print progress (optional)
            if (epoch % 100 == 0 || epoch == epochs - 1) {
                double cost = computeCost(yPred, y);
                System.out.printf("Epoch %4d: w = %.4f, b = %.4f, cost = %.4f%n",
                        epoch, w, b, cost);
            }
        }
    }

    public double[] predict(double[] X) {
        double[] yPred = new double[X.length];
        for (int i = 0; i < X.length; i++) {
            yPred[i] = w * X[i] + b;
        }
        return yPred;
    }

    private double computeCost(double[] yPred, double[] y) {
        double sum = 0;
        for (int i = 0; i < y.length; i++) {
            sum += Math.pow(yPred[i] - y[i], 2);
        }
        return sum / (2 * y.length);
    }

    public static void main(String[] args) {
        // Sample data (same as our example)
        double[] X = {1, 2, 3, 4, 5};  // square feet
        double[] y = {1, 3, 2, 5, 4};  // price in $1000

        // Create and train model
        LinearRegressionGD model = new LinearRegressionGD(0.01, 1000);
        model.fit(X, y);

        // Print final parameters
        System.out.println("\nFinal model parameters:");
        System.out.printf("w (slope) = %.4f%n", model.w);
        System.out.printf("b (intercept) = %.4f%n", model.b);

        // Make predictions
        double[] predictions = model.predict(X);
        System.out.println("\nPredictions vs Actual:");
        System.out.println("X\tActual y\tPredicted y");
        for (int i = 0; i < X.length; i++) {
            System.out.printf("%.1f\t%.1f\t\t%.2f%n", X[i], y[i], predictions[i]);
        }
    }
}
