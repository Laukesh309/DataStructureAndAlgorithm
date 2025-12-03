package GraphStriver;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class primsAlgo {
    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Pair implements Comparable<Pair> {
        int dest;
        int weight;

        Pair(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.weight - p2.weight;
        }
    }

    public static void createGraph(ArrayList<ArrayList<Edge>> graph, int edges[][], int vertex) {

        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];
            graph.get(source).add(new Edge(dest, weight));
            graph.get(dest).add(new Edge(source, weight));
        }

    }

    public static void findMinSpanningTree(ArrayList<ArrayList<Edge>> graph, int vertex, int source) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, 0));
        boolean visited[] = new boolean[vertex];
        int totalCast = 0;
        while (!pq.isEmpty()) {
            Pair curPair = pq.remove();
            int curSource = curPair.dest;
            visited[curSource] = true;
            for (int i = 0; i < graph.get(curSource).size(); i++) {
                int curDest = graph.get(curSource).get(i).dest;
                int weight = graph.get(curSource).get(i).weight;
                totalCast = totalCast + weight;
                if (!visited[curDest]) {
                    pq.add(new Pair(curDest, weight));
                }
            }

        }
        System.out.println(totalCast);

    }

    public static void main(String[] args) {
        int edges[][] = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 2, 1 }, { 2, 4, 2 }, { 2, 3, 2 }, { 3, 4, 1 } };
        int vertex = 5;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        createGraph(graph, edges, vertex);
        findMinSpanningTree(graph, vertex, 0);
    }

}