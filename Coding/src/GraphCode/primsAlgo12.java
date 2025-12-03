package GraphCode;

import java.util.ArrayList;
import java.util.PriorityQueue;

import HashMap.validAnagram;

public class primsAlgo12 {

    static class Pair implements Comparable<Pair> {
        int dest;
        int weight;

        Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Pair P2) {
            return this.weight - P2.weight;
        }
    }

    public static int findMinSpaningTree(ArrayList<ArrayList<Pair>> adj, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        boolean visited[] = new boolean[V];
        int count[] = new int[V];
        int totalSum = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int currentSource = pair.dest;
            int currentPath = pair.weight;

            if (!visited[currentSource]) {
                totalSum = totalSum + currentPath;
            }
            visited[currentSource] = true;

            for (int i = 0; i < adj.get(currentSource).size(); i++) {
                int dest = adj.get(currentSource).get(i).dest;
                int path = adj.get(currentSource).get(i).weight;
                if (!visited[dest]) {
                    pq.add(new Pair(dest, path));
                }
            }
        }
        System.out.println(totalSum);
        return totalSum;

    }

    public static void main(String[] args) {
        int V = 3, E = 3;
        int edges[][] = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];
            adj.get(source).add(new Pair(dest, weight));
            adj.get(dest).add(new Pair(source, weight));
        }
        findMinSpaningTree(adj, V);

    }

}
