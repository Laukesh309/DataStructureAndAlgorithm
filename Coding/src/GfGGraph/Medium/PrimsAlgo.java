package GfGGraph.Medium;

import java.util.ArrayList;
import java.util.PriorityQueue;

import GraphRevision.createGraph.Edge;

public class PrimsAlgo {

    static class Pair implements Comparable<Pair> {
        int dest;
        int cast;

        Pair(int dest, int cast) {
            this.dest = dest;
            this.cast = cast;
        }

        public int compareTo(Pair p2) {
            return this.cast - p2.cast;
        }
    }

    public static void createAdjMatricx(int Edges[][], int V, ArrayList<ArrayList<Pair>> graph) {
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < Edges.length; i++) {
            int source = Edges[i][0];
            int dest = Edges[i][1];
            int cast = Edges[i][2];
            graph.get(source).add(new Pair(dest, cast));
            graph.get(dest).add(new Pair(source, cast));
        }
    }

    public static int findMin(ArrayList<ArrayList<Pair>> graph, int v) {
        boolean visited[] = new boolean[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        int totalCost = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int dest = pair.dest;
            int cast = pair.cast;
            if (visited[dest]) {
                continue;
            }
            totalCost = totalCost + cast;
            visited[dest] = true;
            for (int i = 0; i < graph.get(dest).size(); i++) {
                int neighbour = graph.get(dest).get(i).dest;
                int cost = graph.get(dest).get(i).cast;
                pq.add(new Pair(neighbour, cost));

            }
        }
        return totalCost;

    }

    public static void main(String[] args) {
        int V = 3;
        int Edges[][] = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>(V);
        createAdjMatricx(Edges, V, graph);
        System.out.println(findMin(graph, V));
    }
}
