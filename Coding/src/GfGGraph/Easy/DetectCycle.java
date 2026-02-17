package GfGGraph.Easy;

import java.lang.reflect.Array;
import java.util.ArrayList;

import HashMap.validAnagram;

public class DetectCycle {

    public static void createEdge(int edges[][], int vertex, ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            graph.get(source).add(dest);
            graph.get(dest).add(source);
        }
    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> graph, int currentVertex, boolean visited[],
            int parentIndex) {
        visited[currentVertex] = true;
        for (int i = 0; i < graph.get(currentVertex).size(); i++) {
            int neighbour = graph.get(currentVertex).get(i);
            if (neighbour != parentIndex && visited[neighbour] == true) {
                return true;
            }
            if (visited[neighbour] == false && isCycle(graph, neighbour, visited, currentVertex)) {
                return true;
            }
        }
        return false;

    }

    public static boolean findCycle(ArrayList<ArrayList<Integer>> graph, int V) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                if (isCycle(graph, V, visited, i)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int edges[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 } };
        int V = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
        createEdge(edges, V, graph);

        System.out.println(findCycle(graph, V));
    }

}
