package GraphCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class shortestPathList {

    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        int currentSource;
        int currentWeight;

        Pair(int currentSource, int currentWeight) {
            this.currentSource = currentSource;
            this.currentWeight = currentWeight;
        }

        public int compareTo(Pair p2) {
            return this.currentWeight - p2.currentWeight;
        }

    }

    public static void findShortestPath(ArrayList<ArrayList<Edge>> adj, int V, int source, int destination) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int visited[] = new int[V];
        int parent[] = new int[V];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        pq.add(new Pair(source, 0));
        visited[source] = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int dest = pair.currentSource;
            int currentWeight = pair.currentWeight;
            for (int i = 0; i < adj.get(dest).size(); i++) {
                Edge edge = adj.get(dest).get(i);
                int curDest = edge.dest;
                int curWeight = edge.weight;
                System.out.println("testing" + curDest);
                if (curWeight + currentWeight < visited[curDest]) {
                    visited[curDest] = curWeight + currentWeight;
                    pq.add(new Pair(curDest, curWeight + currentWeight));
                    parent[curDest] = dest;
                }
            }
        }
        ArrayList<Integer> finalResult = new ArrayList<>();
        if (parent[parent.length - 1] == -1) {
            // return -1;
            // return new
            finalResult.add(-1);
            // return finalResult;
            return;
        }
        int currentIndex = parent.length - 1;
        while (currentIndex != -1) {
            finalResult.add(currentIndex + 1);
            currentIndex = parent[currentIndex];

        }
        Collections.reverse(finalResult);
        // return finalResult;
        System.out.println(finalResult);

    }

    public static void main(String[] args) {
        int n = 5;
        int edges[][] = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];
            adj.get(source - 1).add(new Edge(dest - 1, weight));
            adj.get(dest - 1).add(new Edge(source - 1, weight));
        }
        findShortestPath(adj, n, 0, n - 1);

    }

}
