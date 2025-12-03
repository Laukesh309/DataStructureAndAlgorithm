package GraphCode;

import java.util.ArrayList;

public class shortePathBySet {

    public static void main(String[] args) {
        int V = 3, edges[][] = { { 0, 1, 1 }, { 1, 2, 3 }, { 0, 2, 6 } };
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];
            adj.get(source).add(new Edge(dest, weight));
            adj.get(dest).add(new Edge(source, weight));
        }
        findShortestPath(adj, V, 2);
    }

}
