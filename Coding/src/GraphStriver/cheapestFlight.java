package GraphStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class cheapestFlight {

    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Pair {
        int dest;
        int path;
        int k;

        Pair(int dest, int path, int k) {
            this.dest = dest;
            this.path = path;
            this.k = k;
        }
    }

    public static void createGraph(ArrayList<ArrayList<Edge>> graph, int vertex, int flights[][]) {
        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            graph.get(flights[i][0]).add(new Edge(flights[i][1], flights[i][2]));
        }
    }

    public static int cheapestFlight(ArrayList<ArrayList<Edge>> graph, int source, int destination, int vertex, int k) {

        Queue<Pair> que = new LinkedList<>();
        int minCast[] = new int[vertex];
        Arrays.fill(minCast, Integer.MAX_VALUE);
        que.add(new Pair(source, 0, 0));
        while (!que.isEmpty()) {
            Pair pq = que.remove();
            int dest = pq.dest;
            int currPath = pq.path;
            int currK = pq.k;
            for (int i = 0; i < graph.get(dest).size(); i++) {
                int currDest = graph.get(dest).get(i).dest;
                int currWeight = graph.get(dest).get(i).weight;
                if (currPath + currWeight < minCast[currDest] && currK <= k) {
                    minCast[currDest] = currPath + currWeight;
                    que.add(new Pair(currDest, currPath + currWeight, currK + 1));
                }
            }
        }

        if (minCast[destination] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minCast[destination];
        }

    }

    public static void main(String[] args) {
        int n = 5;
        int src = 0;
        int dst = 2;
        int k = 2;
        int flights[][] = { { 0, 1, 5 },
                { 1, 2, 5 },
                { 0, 3, 2 },
                { 3, 1, 2 },
                { 1, 4, 1 },
                { 4, 2, 1 } };
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(n);
        createGraph(graph, n, flights);
        // cheapestFlight(graph, src, dst, n, k);
        System.out.println(cheapestFlight(graph, src, dst, n, k));

    }

}
