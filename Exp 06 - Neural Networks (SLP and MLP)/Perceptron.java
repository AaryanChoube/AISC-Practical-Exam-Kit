import java.util.Scanner;

public class Perceptron {
    public static void trainPerceptron(int[][] inputs, int[] targets, String gateName) {
        double[] weights = {0.0, 0.0};
        double bias = 0.0;
        double lr = 0.1;
        int epochs = 10;

        System.out.println("\n--- Training Perceptron for " + gateName + " Gate ---");
        System.out.println("Learning Rate: " + lr);

        for (int epoch = 1; epoch <= epochs; epoch++) {
            int totalError = 0;
            for (int i = 0; i < inputs.length; i++) {
                double net = inputs[i][0] * weights[0] + inputs[i][1] * weights[1] + bias;
                int output = (net >= 0) ? 1 : 0;
                int error = targets[i] - output;
                totalError += Math.abs(error);

                weights[0] += lr * error * inputs[i][0];
                weights[1] += lr * error * inputs[i][1];
                bias += lr * error;
            }

            if (totalError == 0) {
                System.out.println("Converged at Epoch " + epoch + "!");
                break;
            }
        }

        System.out.printf("Final Weights: w1 = %.2f, w2 = %.2f, bias = %.2f\n", weights[0], weights[1], bias);
        System.out.println("Verification Table:");
        System.out.println("x1\tx2\tTarget\tPredicted\tStatus");
        for (int i = 0; i < inputs.length; i++) {
            double net = inputs[i][0] * weights[0] + inputs[i][1] * weights[1] + bias;
            int pred = (net >= 0) ? 1 : 0;
            System.out.println(inputs[i][0] + "\t" + inputs[i][1] + "\t" + targets[i] + "\t" + pred + "\t\t" + (pred == targets[i] ? "MATCH" : "FAIL"));
        }
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   Single-Layer Perceptron (AISC Exp 6)");
        System.out.println("========================================");

        int[][] inputs = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
        };

        int[] andTargets = {0, 0, 0, 1};
        int[] orTargets = {0, 1, 1, 1};

        trainPerceptron(inputs, andTargets, "AND");
        trainPerceptron(inputs, orTargets, "OR");

        System.out.println("\nNote: SLP can solve linearly separable problems (AND, OR).");
        System.out.println("XOR is non-linearly separable and requires Multi-Layer Perceptron (MLP).");
        System.out.println("========================================");
    }
}
