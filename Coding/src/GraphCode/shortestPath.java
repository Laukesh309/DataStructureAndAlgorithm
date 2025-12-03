package GraphCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class shortestPath {

    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        int source;
        int path;

        Pair(int source, int path) {
            this.source = source;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            if (this.path < p2.path) {
                return -1;
            } else if (this.path > p2.path) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    public static void findShortestPath(ArrayList<ArrayList<Edge>> adj, int V, int source) {
        int visited[] = new int[V];
        Arrays.fill(visited, Integer.MAX_VALUE);
        TreeSet<Pair> pq = new TreeSet<>();
        pq.add(new Pair(source, 0));
        visited[source] = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.pollFirst();
            int curSource = pair.source;
            int curPath = pair.path;
            for (int i = 0; i < adj.get(curSource).size(); i++) {
                Edge pairDest = adj.get(curSource).get(i);
                int dest = pairDest.dest;
                int weight = pairDest.weight;
                if (curPath + weight < visited[dest]) {
                    visited[dest] = curPath + weight;
                    pq.add(new Pair(dest, curPath + weight));
                }
            }

        }
        for (int pair : visited) {
            System.out.println(pair);
        }

    }

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
