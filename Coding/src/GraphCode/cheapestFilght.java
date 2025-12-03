package GraphCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class cheapestFilght {
    static class Edge {
        int dest;
        int weight;

        Edge(int sourceCol, int weight) {
            this.dest = sourceCol;
            this.weight = weight;
        }
    }

    static class Pair {
        int dest;
        int level;
        int weight;

        Pair(int dest, int level, int weight) {
            this.dest = dest;
            this.level = level;
            this.weight = weight;
        }

    }

    public static void findCheapestFlight(ArrayList<ArrayList<Edge>> adj, int src, int dest, int k,
            int n) {
        Queue<Pair> que = new LinkedList<>();
        int visited[] = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        que.add(new Pair(src, 0, 0));
        int min = Integer.MAX_VALUE;
        visited[src] = 0;
        while (!que.isEmpty()) {
            Pair pq = que.poll();

            int curDest = pq.dest;
            // System.out.println("-->" + curDest);
            int weight = pq.weight;
            int level = pq.level;
            if (curDest == dest) {
                min = Math.min(weight, min);
            }
            for (int i = 0; i < adj.get(curDest).size(); i++) {
                Edge currentDest = adj.get(curDest).get(i);
                int currentWeight = currentDest.weight;
                int currentDest1 = currentDest.dest;
                if (weight + currentWeight < visited[currentDest1] && level <= k) {
                    que.add(new Pair(currentDest1, level + 1, currentWeight + weight));
                    visited[currentDest1] = currentWeight + weight;
                }

            }

        }
        // return min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(min);

    }

    public static void main(String[] args) {
        int n = 5;
        int flights[][] = { { 0, 1, 5 },
                { 1, 2, 5 },
                { 0, 3, 2 },
                { 3, 1, 2 },
                { 1, 4, 1 },
                { 4, 2, 1 } };
        int src = 0;
        int dst = 2;
        int k = 2;
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            int source = flights[i][0];
            int dest = flights[i][1];
            int weight = flights[i][2];
            adj.get(source).add(new Edge(dest, weight));
        }
        findCheapestFlight(adj, src, dst, k, n);

    }

}
