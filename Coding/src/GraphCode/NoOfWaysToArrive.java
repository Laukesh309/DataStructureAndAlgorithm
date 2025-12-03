package GraphCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import GraphCode.Dijikstra.Pair;

public class NoOfWaysToArrive {

    static class Edges {
        int dest;
        int cast;

        Edges(int dest, int cast) {
            this.dest = dest;
            this.cast = cast;
        }
    }

    static class Pair implements Comparable<Pair> {
        int dest;
        long totalPath;

        Pair(int dest, long totalPath) {
            this.dest = dest;
            this.totalPath = totalPath;
        }

        public int compareTo(Pair p2) {
            return (int) (this.totalPath - p2.totalPath);
        }

    }

    public static void findAllPath(ArrayList<ArrayList<Edges>> adj, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int visited[] = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        pq.add(new Pair(0, 0));
        visited[0] = 0;
        int count[] = new int[n];
        Arrays.fill(count, 0);
        count[0] = 1;
        int modulo = (int) (1e9 + 7);
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int currentSouce = pair.dest;
            long currentPath = pair.totalPath;
            for (int i = 0; i < adj.get(currentSouce).size(); i++) {
                Edges destPair = adj.get(currentSouce).get(i);
                int dest = destPair.dest;
                long cast = destPair.cast;
                if (currentPath + cast < visited[dest]) {
                    pq.add(new Pair(dest, currentPath + cast));
                    visited[dest] = (int) (currentPath + cast) % modulo;
                    count[dest] = count[currentSouce];
                } else if ((currentPath + cast) == visited[dest]) {
                    count[dest] = count[dest] + count[currentSouce];
                    System.out.println(currentSouce + " " + dest);
                }
            }

        }
        System.out.println(count[n - 1]);

    }

    public static void main(String[] args) {
        int n = 7;
        int edges[][] = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
                { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
        ArrayList<ArrayList<Edges>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            int cast = edges[i][2];
            adj.get(source).add(new Edges(dest, cast));
            adj.get(dest).add(new Edges(source, cast));
        }
        findAllPath(adj, n);

    }

}
