package GraphStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class shortestPathWeighted {

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
        int path;

        Pair(int dest, int path) {
            this.path = path;
            this.dest = dest;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }

    }

    public static void createGraph(ArrayList<ArrayList<Edge>> graph, int v, int edge[][]) {

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            int src = edge[i][0];
            int dest = edge[i][1];
            int weight = edge[i][2];
            graph.get(src).add(new Edge(dest, weight));
            graph.get(dest).add(new Edge(src, weight));
        }

    }

    public static void findShortestPath(ArrayList<ArrayList<Edge>> graph, int source, int dest, int v) {
        int parent[] = new int[v + 1];
        int dist[] = new int[v + 1];
        Arrays.fill(parent, -1);
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Pair> que = new PriorityQueue<>();
        que.add(new Pair(source, 0));
        while (!que.isEmpty()) {
            Pair currentPair = que.remove();
            int curSource = currentPair.dest;
            int curWeight = currentPair.path;
            for (int i = 0; i < graph.get(curSource).size(); i++) {
                int currDest = graph.get(curSource).get(i).dest;
                int weight = graph.get(curSource).get(i).weight;
                if (curWeight + weight < dist[currDest]) {
                    dist[currDest] = curWeight + weight;
                    parent[currDest] = curSource;
                    que.add(new Pair(currDest, curWeight + weight));
                }
            }
        }
        ArrayList<Integer> finalResult = new ArrayList<>();
        if (parent[v - 1] == -1) {
            finalResult.add(-1);
            System.out.println();
        }

        int curParent = v - 1;
        finalResult.add(curParent);
        while (curParent != 1) {
            finalResult.add(0, parent[curParent]);
            curParent = parent[curParent];
        }
        finalResult.add(0, dist[v - 1]);
        System.out.println(finalResult);

    }

    public static void main(String[] args) {
        int n = 5;
        int m = 6;
        int edge[][] = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(n + 1);
        createGraph(graph, n + 1, edge);
        findShortestPath(graph, 1, n, n + 1);

    }

}
