package GfGGraph.Medium;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    static class Pair implements Comparable<Pair> {
        int dest;
        int cost;

        Pair(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }

        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }
    }

    public static void createGraph(int edges[][], int V, ArrayList<ArrayList<Pair>> graph) {
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            int cost = edges[i][2];
            graph.get(source).add(new Pair(dest, cost));
            graph.get(dest).add(new Pair(source, cost));
        }

    }

    public static void printArray(int path[]) {
        for (int i : path) {
            System.out.print(i + " ");
        }
    }

    public static int findShortestPath(ArrayList<ArrayList<Pair>> graph, int V, int sourceVertex) {
        int path[] = new int[V];
        for (int i = 0; i < V; i++) {
            path[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(sourceVertex, 0));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int currentVertex = pair.dest;
            int currentCost = pair.cost;
            if (path[currentVertex] != Integer.MAX_VALUE) {
                continue;
            }
            path[currentVertex] = currentCost;
            for (int i = 0; i < graph.get(currentVertex).size(); i++) {
                int neighbour = graph.get(currentVertex).get(i).dest;
                int cost = graph.get(currentVertex).get(i).cost;
                if (path[neighbour] == Integer.MAX_VALUE) {
                    pq.add(new Pair(neighbour, cost + currentCost));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int V = 5;
        int src = 0;
        int edges[][] = { { 0, 1, 4 }, { 0, 2, 8 }, { 1, 4, 6 }, { 2, 3, 2 }, { 3, 4, 10 } };
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        createGraph(edges, V, graph);
        findShortestPath(graph, V, src);
    }

}
