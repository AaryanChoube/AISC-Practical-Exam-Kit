import java.util.*;

public class AStarSearch {
    static class Node implements Comparable<Node> {
        int id;
        int g;
        int h;
        int f;
        Node parent;

        Node(int id, int g, int h, Node parent) {
            this.id = id;
            this.g = g;
            this.h = h;
            this.f = g + h;
            this.parent = parent;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.f, o.f);
        }
    }

    static class Edge {
        int target, weight;
        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void runAStar(Map<Integer, List<Edge>> graph, int[] heuristics, int start, int goal) {
        PriorityQueue<Node> openList = new PriorityQueue<>();
        Map<Integer, Integer> bestG = new HashMap<>();

        openList.add(new Node(start, 0, heuristics[start], null));
        bestG.put(start, 0);

        System.out.println("\n--- A* Search Node Expansion ---");
        System.out.println("Node\tg(n)\th(n)\tf(n)");

        while (!openList.isEmpty()) {
            Node current = openList.poll();
            System.out.printf("N%d\t%d\t%d\t%d\n", current.id, current.g, current.h, current.f);

            if (current.id == goal) {
                System.out.println("\nGoal Node " + goal + " reached with optimal cost: " + current.g);
                printPath(current);
                return;
            }

            for (Edge edge : graph.getOrDefault(current.id, Collections.emptyList())) {
                int newG = current.g + edge.weight;
                int neighbor = edge.target;

                if (!bestG.containsKey(neighbor) || newG < bestG.get(neighbor)) {
                    bestG.put(neighbor, newG);
                    openList.add(new Node(neighbor, newG, heuristics[neighbor], current));
                }
            }
        }
        System.out.println("Goal node is unreachable.");
    }

    private static void printPath(Node goalNode) {
        List<Integer> path = new ArrayList<>();
        Node curr = goalNode;
        while (curr != null) {
            path.add(curr.id);
            curr = curr.parent;
        }
        Collections.reverse(path);
        System.out.print("Optimal Path: ");
        for (int i = 0; i < path.size(); i++) {
            System.out.print("N" + path.get(i) + (i < path.size() - 1 ? " -> " : ""));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("      A* Search Algorithm (AISC Exp 4)");
        System.out.println("========================================");

        int[] heuristics = {10, 8, 5, 7, 3, 0};
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < 6; i++) graph.put(i, new ArrayList<>());

        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(2, 4));
        graph.get(1).add(new Edge(3, 7));
        graph.get(1).add(new Edge(4, 3));
        graph.get(2).add(new Edge(4, 1));
        graph.get(3).add(new Edge(5, 5));
        graph.get(4).add(new Edge(5, 4));

        System.out.println("Graph configured with Start = N0, Goal = N5");
        System.out.println("Heuristics h(n): N0=10, N1=8, N2=5, N3=7, N4=3, N5=0");

        runAStar(graph, heuristics, 0, 5);
        System.out.println("Evaluation Function: f(n) = g(n) + h(n)");
        System.out.println("Optimality: A* is optimal if heuristic h(n) is admissible (never overestimates).");
        System.out.println("========================================");
    }
}
