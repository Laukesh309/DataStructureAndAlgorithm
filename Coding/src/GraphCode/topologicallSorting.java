package GraphCode;

import java.util.ArrayList;
import java.util.Stack;

public class topologicallSorting {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void buildGraph(ArrayList<Edge> graph[]) {
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topologicalSort(ArrayList<Edge> graph[], int currentVertex, Stack<Integer> stack,
            boolean visited[]) {
        visited[currentVertex] = true;
        for (int i = 0; i < graph[currentVertex].size(); i++) {
            Edge edge = graph[currentVertex].get(i);
            if (!visited[edge.dest]) {
                topologicalSort(graph, edge.dest, stack, visited);
            }
        }
        stack.add(currentVertex);
    }

    public static void formTopologicalSort(ArrayList<Edge> graph[]) {

        boolean visited[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                topologicalSort(graph, i, stack, visited);
            }
        }
        System.out.println(stack);
    }

    public static void main(String[] args) {
        int totalVertex = 6;
        ArrayList<Edge> graph[] = new ArrayList[totalVertex];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        buildGraph(graph);
        formTopologicalSort(graph);
    }

}
