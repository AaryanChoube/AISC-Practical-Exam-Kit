import java.util.*;

public class WaterJugSolver {
    static class State {
        int x, y;
        List<String> path;

        State(int x, int y, List<String> path) {
            this.x = x;
            this.y = y;
            this.path = new ArrayList<>(path);
            this.path.add("(" + x + ", " + y + ")");
        }
    }

    public static void solveBFS(int jug1, int jug2, int target) {
        System.out.println("\nSolving Water Jug Problem using BFS (Shortest Path):");
        System.out.println("Jug 1 Capacity: " + jug1 + "L | Jug 2 Capacity: " + jug2 + "L | Target: " + target + "L");

        if (target > Math.max(jug1, jug2) || target % gcd(jug1, jug2) != 0) {
            System.out.println("Target cannot be measured according to Bezout's identity.");
            return;
        }

        Queue<State> queue = new LinkedList<>();
        boolean[][] visited = new boolean[jug1 + 1][jug2 + 1];

        queue.add(new State(0, 0, new ArrayList<>()));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.x == target || current.y == target) {
                System.out.println("\nGoal State Reached!");
                System.out.println("Steps to solution (" + (current.path.size() - 1) + " operations):");
                for (int i = 0; i < current.path.size(); i++) {
                    System.out.println("Step " + i + ": " + current.path.get(i));
                }
                return;
            }

            List<int[]> nextStates = new ArrayList<>();
            nextStates.add(new int[]{jug1, current.y}); // Fill Jug 1
            nextStates.add(new int[]{current.x, jug2}); // Fill Jug 2
            nextStates.add(new int[]{0, current.y});    // Empty Jug 1
            nextStates.add(new int[]{current.x, 0});    // Empty Jug 2

            int pour1to2 = Math.min(current.x, jug2 - current.y);
            nextStates.add(new int[]{current.x - pour1to2, current.y + pour1to2});

            int pour2to1 = Math.min(current.y, jug1 - current.x);
            nextStates.add(new int[]{current.x + pour2to1, current.y - pour2to1});

            for (int[] next : nextStates) {
                int nx = next[0], ny = next[1];
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new State(nx, ny, current.path));
                }
            }
        }
        System.out.println("No solution exists.");
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("   Water Jug Problem Solver (AISC Exp 2)");
        System.out.println("========================================");
        System.out.println("1. Use default: Jug1 = 4L, Jug2 = 3L, Target = 2L");
        System.out.println("2. Enter custom values");
        System.out.print("Enter choice (1/2): ");

        int choice = 1;
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        }

        int j1 = 4, j2 = 3, target = 2;
        if (choice == 2) {
            System.out.print("Enter capacity of Jug 1: ");
            j1 = sc.nextInt();
            System.out.print("Enter capacity of Jug 2: ");
            j2 = sc.nextInt();
            System.out.print("Enter target amount: ");
            target = sc.nextInt();
        }

        solveBFS(j1, j2, target);
        System.out.println("========================================");
    }
}
