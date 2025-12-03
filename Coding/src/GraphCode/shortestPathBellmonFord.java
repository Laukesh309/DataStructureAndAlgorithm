package GraphCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class shortestPathBellmonFord {
    static class Edge {
        int dest;
        int path;

        Edge(int dest, int path) {
            this.dest = dest;
            this.path = path;
        }
    }

    static class Pair implements Comparable<Pair> {
        int dest;
        int path;

        Pair(int dest, int path) {
            this.dest = dest;
            this.path = path;
        }

        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void findShortestPath(int edge[][], int source, int V) {
        int visited[] = new int[V];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[source] = 0;
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < edge.length; j++) {
                int src = edge[j][0];
                int dest = edge[j][1];
                int weight = edge[j][2];
                if (visited[src] != Integer.MAX_VALUE && visited[src] + weight < visited[dest]) {
                    visited[dest] = visited[src] + weight;
                }
            }
        }
        boolean isChange = false;
        for (int j = 0; j < edge.length; j++) {
            int src = edge[j][0];
            int dest = edge[j][1];
            int weight = edge[j][2];
            if (visited[src] != Integer.MAX_VALUE && visited[src] + weight < visited[dest]) {
                visited[dest] = visited[src] + weight;
                isChange = true;
            }
        }
        int result[] = { -1 };
        if (isChange) {

        }

    }

    public static void main(String[] args) {
        int V = 5;

        int edges[][] = { { 1, 3, 2 }, { 4, 3, -1 }, { 2, 4, 1 }, { 1, 2, 1 }, { 0, 1, 5 } };
        findShortestPath(edges, 0, V);

    }

}
