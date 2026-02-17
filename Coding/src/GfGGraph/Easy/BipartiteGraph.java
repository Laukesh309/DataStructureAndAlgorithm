package GfGGraph.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {

    public static void createGraph(int edges[][], int V, ArrayList<ArrayList<Integer>> graph) {
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

    public static boolean findIsBipartite(ArrayList<ArrayList<Integer>> graph, int V) {

        int color[] = new int[V];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        color[0] = 1;
        while (!que.isEmpty()) {
            int currentVertex = que.poll();
            for (int i = 0; i < graph.get(currentVertex).size(); i++) {
                int neighbor = graph.get(currentVertex).get(i);
                if (color[neighbor] == 0) {
                    que.add(neighbor);
                    color[neighbor] = -color[currentVertex];
                } else {
                    if (color[neighbor] == color[currentVertex]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int edges[][] = { { 0, 3 }, { 1, 2 }, { 3, 2 }, { 0, 2 } };
        int V = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
        createGraph(edges, V, graph);
        System.out.println(findIsBipartite(graph, V));

    }

}
