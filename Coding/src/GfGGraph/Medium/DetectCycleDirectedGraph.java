package GfGGraph.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleDirectedGraph {

    public static void createGraph(int edges[][], ArrayList<ArrayList<Integer>> graph, int V) {
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            graph.get(source).add(dest);
        }
    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> graph, int currentIndex, boolean visited[]) {

        visited[currentIndex] = true;
        for (int i = 0; i < graph.get(currentIndex).size(); i++) {
            int neighbor = graph.get(currentIndex).get(i);
            if (visited[neighbor]) {
                return true;
            }
            if (isCycle(graph, neighbor, visited)) {
                return true;
            }
        }
        visited[currentIndex] = false;
        return false;

    }

    public static boolean checkCycle(ArrayList<ArrayList<Integer>> graph, int V) {

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCycle(graph, i, visited)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean checkCycleBoolean(ArrayList<ArrayList<Integer>> graph, int V) {
        Queue<Integer> que = new LinkedList<>();
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int neighbour = graph.get(i).get(j);
                indegree[neighbour]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }
        int visited = 0;
        while (!que.isEmpty()) {
            int currentIndex = que.poll();
            visited++;
            for (int i = 0; i < graph.get(currentIndex).size(); i++) {
                int neighbour = graph.get(currentIndex).get(i);
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    que.add(neighbour);
                }
            }

        }
        if (visited == V) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        int V = 4;
        int edges[][] = { { 0, 3 }, { 0, 1 }, { 1, 3 } };
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
        createGraph(edges, graph, V);
        System.out.println(graph);
        System.out.println(checkCycle(graph, V));
        System.out.println(checkCycleBoolean(graph, V));

    }

}
