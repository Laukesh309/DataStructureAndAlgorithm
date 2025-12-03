package GraphStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class shortestPathAcyclicGraph {

    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(List<ArrayList<Edge>> graph, int V, int E, int edge[][]) {
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int source = edge[i][0];
            int dest = edge[i][1];
            int weight = edge[i][2];
            graph.get(source).add(new Edge(dest, weight));
        }

    }

    public static void findEdge(List<ArrayList<Edge>> graph, int source, boolean visited[], int currentPathLength,
            int result[]) {
        result[source] = Math.min(result[source], currentPathLength);
        for (int i = 0; i < graph.get(source).size(); i++) {
            Edge edge = graph.get(source).get(i);
            int dest = edge.dest;
            int weight = edge.weight;
            if (!visited[dest] || result[source] + weight < result[dest]) {
                findEdge(graph, dest, visited, result[source] + weight, result);
            }
        }
    }

    public static void printArray(int result[]) {
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static void dfs(List<ArrayList<Edge>> graph, int source, Stack<Integer> stack) {
        for (int i = 0; i < graph.get(source).size(); i++) {
            int dest = graph.get(source).get(i).dest;
            if (!stack.contains(dest)) {
                dfs(graph, dest, stack);
            }
        }
        stack.add(source);
    }

    public static void topoSort(List<ArrayList<Edge>> graph, int src, int result[]) {
        Stack<Integer> st = new Stack<>();
        dfs(graph, src, st);
        result[src] = 0;
        while (!st.isEmpty()) {
            int curElement = st.pop();
            for (int i = 0; i < graph.get(curElement).size(); i++) {
                int dest = graph.get(curElement).get(i).dest;
                int weight = graph.get(curElement).get(i).weight;
                result[dest] = Math.min(result[dest], result[curElement] + weight);
            }
        }

    }

    public static void main(String[] args) {
        int V = 10, E = 24;
        int edges[][] = { { 0, 2, 6 },
                { 0, 3, 7 },
                { 0, 4, 9 },
                { 0, 6, 8 },
                { 0, 7, 6 },
                { 1, 2, 6 },
                { 1, 3, 7 },
                { 1, 5, 10 },
                { 1, 6, 1 },
                { 1, 7, 4 },
                { 2, 3, 3 },
                { 2, 6, 10 },
                { 2, 8, 8 },
                { 2, 9, 10 },
                { 3, 5, 3 },
                { 3, 6, 10 },
                { 3, 7, 5 },
                { 5, 6, 9 },
                { 5, 7, 7 },
                { 6, 7, 7 },
                { 6, 8, 8 },
                { 6, 9, 8 },
                { 7, 9, 1 },
                { 8, 9, 6 } };

        List<ArrayList<Edge>> graph = new ArrayList<>();
        createGraph(graph, V, E, edges);
        int result[] = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        // boolean visited[] = new boolean[V];
        // findEdge(graph, 0, visited, 0, result);
        topoSort(graph, 0, result);
        for (int i = 0; i < result.length; i++) {
            if (result[i] == Integer.MAX_VALUE) {
                result[i] = -1;
            }
        }
        printArray(result);
    }
}