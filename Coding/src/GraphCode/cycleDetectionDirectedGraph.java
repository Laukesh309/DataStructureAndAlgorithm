package GraphCode;

import java.util.ArrayList;

public class cycleDetectionDirectedGraph {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        // graph[1].add(new Edge(1, 3));
        // graph[2].add(new Edge(2, 3));

    }

    public static boolean cycleDetected(ArrayList<Edge> graph[], int currentVertex, boolean visited[],
            boolean stack[]) {
        visited[currentVertex] = true;
        stack[currentVertex] = true;

        for (int i = 0; i < graph[currentVertex].size(); i++) {
            Edge edge = graph[currentVertex].get(i);
            if (stack[edge.dest]) {
                return true;
            }
            if (!visited[edge.dest] && cycleDetected(graph, edge.dest, visited, stack)) {
                return true;
            }

        }
        stack[currentVertex] = false;
        return false;

    }

    public static boolean isCycleDetected(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (cycleDetected(graph, i, visited, stack)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int totalVertex = 4;
        ArrayList<Edge> graph[] = new ArrayList[totalVertex];
        createGraph(graph);
        System.out.println(isCycleDetected(graph));

    }

}
