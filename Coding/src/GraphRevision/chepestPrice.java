package GraphRevision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class chepestPrice {

    static class Edge {
        int source;
        int dest;
        int weight;

        Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }

    }

    static class Pair implements Comparable<Pair> {
        int dest;
        int path;
        int k;

        Pair(int dest, int path, int k) {
            this.dest = dest;
            this.path = path;
            this.k = k;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static int findChepestPrice(ArrayList<Edge> graph[], int source, int dest, int totalCast, boolean visited[],
            int k) {
        if (visited[source] || k < 0) {
            return -1;
        }
        if (source == dest) {
            return totalCast;
        }
        visited[source] = true;
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < graph[source].size(); i++) {
            int curSource = graph[source].get(i).dest;
            int curPath = findChepestPrice(graph, curSource, dest, totalCast + graph[source].get(i).weight, visited,
                    k - 1);
            if (curPath != -1) {
                minPath = Math.min(minPath, curPath);
            }
        }
        visited[source] = false;
        return minPath != Integer.MAX_VALUE ? minPath : -1;

    }

    public static int findMinDistance(ArrayList<Edge> graph[], int source, int dest, int k) {
        int result = Integer.MAX_VALUE;
        int matrix[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            matrix[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, 0, k));
        while (!pq.isEmpty()) {
            Pair currPair = pq.remove();
            System.out.println(currPair.dest);
            if (currPair.dest == dest && currPair.k >= -1) {
                result = Math.min(result, currPair.path);
            }
            if (currPair.k >= 0) {
                for (int i = 0; i < graph[currPair.dest].size(); i++) {
                    Edge edge = graph[currPair.dest].get(i);
                    int destination = edge.dest;
                    int currPath = currPair.path + edge.weight;
                    pq.add(new Pair(destination, currPath, currPair.k - 1));

                }
            }

        }

        return result == Integer.MAX_VALUE ? -1 : result;

    }

    public static void main(String[] args) {
        int n = 6;
        int flight[][] = { { 0, 1, 5 }, { 1, 2, 5 }, { 0, 3, 2 }, { 3, 1, 2 }, { 1, 4, 1 }, { 4, 2, 1 } };
        boolean visited[] = new boolean[n];
        int source = 0;
        int dest = 2;
        int k = 2;
        ArrayList<Edge> graph[] = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < flight.length; i++) {
            int row[] = flight[i];
            graph[row[0]].add(new Edge(row[0], row[1], row[2]));
        }
        System.out.println(findChepestPrice(graph, source, dest, 0, visited, k + 1));
        System.out.println(findMinDistance(graph, source, dest, k));
    }

}
