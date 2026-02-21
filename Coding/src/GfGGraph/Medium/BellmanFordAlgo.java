package GfGGraph.Medium;

import java.util.Arrays;

public class BellmanFordAlgo {

    public static int[] bellmanFord(int V, int edges[][], int src) {

        int dist[] = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i <= V; i++) {
            for (int edge[] : edges) {
                int source = edge[0];
                int dest = edge[1];
                int weight = edge[2];
                if (dist[source] != Integer.MAX_VALUE && dist[source] + weight < dist[dest]) {
                    if (i == V) {
                        return new int[] { -1 };
                    }
                    dist[dest] = dist[source] + weight;
                }
            }
        }
        return dist;

    }

    public static void main(String[] args) {
        int V = 5;

        int[][] edges = new int[][] {
                { 1, 3, 2 },
                { 4, 3, -1 },
                { 2, 4, 1 },
                { 1, 2, 1 },
                { 0, 1, 5 }
        };

        // Source vertex for Bellman-Ford algorithm
        int src = 0;

        int dist[] = bellmanFord(V, edges, src);
        for (int i : dist) {
            System.out.println(i);
        }
    }

}
