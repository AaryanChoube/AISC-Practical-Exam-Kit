import java.util.Scanner;

public class FuzzyOperations {
    public static void printSet(String name, double[] set) {
        System.out.print(name + " = { ");
        for (int i = 0; i < set.length; i++) {
            System.out.printf("%.2f/x%d", set[i], (i + 1));
            if (i < set.length - 1) System.out.print(", ");
        }
        System.out.println(" }");
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("      Fuzzy Set Operations (AISC Exp 8)");
        System.out.println("========================================");

        double[] A = {0.2, 0.5, 0.8, 1.0};
        double[] B = {0.6, 0.4, 0.7, 0.1};

        printSet("Fuzzy Set A", A);
        printSet("Fuzzy Set B", B);

        int n = A.length;
        double[] union = new double[n];
        double[] intersection = new double[n];
        double[] compA = new double[n];
        double[] compB = new double[n];
        double[] diffAB = new double[n];

        for (int i = 0; i < n; i++) {
            union[i] = Math.max(A[i], B[i]);
            intersection[i] = Math.min(A[i], B[i]);
            compA[i] = 1.0 - A[i];
            compB[i] = 1.0 - B[i];
            diffAB[i] = Math.min(A[i], 1.0 - B[i]);
        }

        System.out.println("\n--- Standard Fuzzy Operations ---");
        printSet("Union (A ∪ B)        [max]", union);
        printSet("Intersection (A ∩ B) [min]", intersection);
        printSet("Complement (A')      [1 - A]", compA);
        printSet("Difference (A - B)   [A ∩ B']", diffAB);

        System.out.println("\n--- Cartesian Product (A × B) ---");
        double[][] cartesian = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cartesian[i][j] = Math.min(A[i], B[j]);
                System.out.printf("%.2f\t", cartesian[i][j]);
            }
            System.out.println();
        }

        System.out.println("\n--- Max-Min Composition Demo ---");
        double[][] R = {{0.3, 0.7}, {0.8, 0.4}};
        double[][] S = {{0.5, 0.9}, {0.6, 0.2}};
        double[][] T = new double[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                double maxVal = 0.0;
                for (int k = 0; k < 2; k++) {
                    maxVal = Math.max(maxVal, Math.min(R[i][k], S[k][j]));
                }
                T[i][j] = maxVal;
            }
        }

        System.out.println("Composition Matrix T = R ∘ S:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf("%.2f\t", T[i][j]);
            }
            System.out.println();
        }
        System.out.println("========================================");
    }
}
