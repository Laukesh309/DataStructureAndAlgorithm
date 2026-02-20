package GfGGraph.Medium;

import java.util.ArrayList;

public class PathExists {

    public static void createAdj(int edges[][], int V, ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            graph.get(source).add(dest);
            graph.get(dest).add(source);
        }
    }

    public static boolean findPath(ArrayList<ArrayList<Integer>> graph, int src, int dest, boolean visited[]) {
        if (src == dest) {
            return true;
        }
        visited[src] = true;
        for (int i = 0; i < graph.get(src).size(); i++) {
            int neighbour = graph.get(src).get(i);
            if (!visited[neighbour] && findPath(graph, neighbour, dest, visited)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 6;
        int edges[][] = { { 0, 2 }, { 1, 2 }, { 0, 3 }, { 4, 5 } };
        int src = 2, dest = 3;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        createAdj(edges, V, graph);
        boolean visited[] = new boolean[V];
        System.out.println(findPath(graph, src, dest, visited));
    }

}
