package GraphStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class NoOfWaysArrivingDestination {

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
        long path;

        Pair(int dest, long path) {
            this.dest = dest;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return (int) (this.path - p2.path);
        }

    }

    public static void createGraph(ArrayList<ArrayList<Edge>> graph, List<List<Integer>> edges, int vertex) {

        for (int i = 0; i < vertex; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            int source = edges.get(i).get(0);
            int dest = edges.get(i).get(1);
            int weight = edges.get(i).get(2);
            graph.get(source).add(new Edge(dest, weight));
            graph.get(dest).add(new Edge(source, weight));
        }

    }

    public static void printArray(int cout[]) {
        for (int i : cout) {
            System.out.print(i + " ");
        }
    }

    public static int countTotalPath(ArrayList<ArrayList<Edge>> graph, int source, int dest, int vertex) {
        PriorityQueue<Pair> que = new PriorityQueue<>();
        long visited[] = new long[vertex];
        Arrays.fill(visited, Integer.MAX_VALUE);
        que.add(new Pair(source, 0));
        visited[source] = 0;
        int count[] = new int[vertex];
        count[0] = 1;
        int mod = (int) (1e9 + 7);
        while (!que.isEmpty()) {
            Pair curPair = que.remove();
            int curSource = curPair.dest;
            for (int i = 0; i < graph.get(curSource).size(); i++) {
                int curDest = graph.get(curSource).get(i).dest;
                int weight = graph.get(curSource).get(i).weight;
                long totalWeight = visited[curSource] + weight;
                if (totalWeight < visited[curDest]) {
                    count[curDest] = count[curSource];
                    visited[curDest] = totalWeight;
                    que.add(new Pair(curDest, totalWeight));
                } else if (totalWeight == visited[curDest]) {
                    count[curDest] = (count[curDest] + count[curSource]) % mod;
                }
            }
        }
        printArray(count);
        return count[dest] % mod;
    }

    public static void main(String[] args) {
        int n = 6;
        int m = 10;
        List<List<Integer>> edges = new ArrayList<>();

        int temp1[][] = { { 0, 1, 1000000000 },
                { 0, 3, 1000000000 },
                { 1, 3, 1000000000 },
                { 1, 2, 1000000000 },
                { 1, 5, 1000000000 },
                { 3, 4, 1000000000 },
                { 4, 5, 1000000000 },
                { 2, 5, 1000000000 } };

        for (int i = 0; i < temp1.length; i++) {
            ArrayList<Integer> temp2 = new ArrayList<>();
            temp2.add(temp1[i][0]);
            temp2.add(temp1[i][1]);
            temp2.add(temp1[i][2]);
            edges.add(temp2);
        }

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(n);

        createGraph(graph, edges, n);
        System.out.println(countTotalPath(graph, 0, n - 1, n));

    }
}
