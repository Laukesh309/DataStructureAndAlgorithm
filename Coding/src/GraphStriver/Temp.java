package GraphStriver;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class DisjointSet1 {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet1(int vertex) {
        for (int i = 0; i < vertex; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int n) {
        if (n == parent.get(n)) {
            return n;
        } else {
            int tempParent = findParent(parent.get(n));
            parent.set(n, tempParent);
            return tempParent;
        }
    }

    public void findUnion(int u, int v) {
        int uParent = findParent(u);
        int vParent = findParent(v);
        if (uParent == vParent) {
            return;
        }
        if (rank.get(uParent) < rank.get(vParent)) {
            parent.set(uParent, parent.get(vParent));
        } else if (rank.get(uParent) > rank.get(vParent)) {
            parent.set(vParent, parent.get(uParent));
        } else {
            parent.set(uParent, parent.get(vParent));
            rank.set(vParent, rank.get(vParent) + 1);
        }
    }
}

public class Temp {

    static class Edge implements Comparable<Edge> {
        int source;
        int dest;
        int weight;

        Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge p2) {
            return this.weight - p2.weight;
        }

    }

    public static void createGraph(int edges[][], int vertex, PriorityQueue<Edge> pq) {
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];
            pq.add(new Edge(source, dest, weight));
        }

    }

    public static void findMinimumTree(PriorityQueue<Edge> pq, int vertex) {
        int total = 0;
        DisjointSet1 ds = new DisjointSet1(vertex);

        while (!pq.isEmpty()) {
            Edge pair = pq.remove();
            int source = pair.source;
            int dest = pair.dest;
            int weight = pair.weight;
            if (ds.findParent(source) != ds.findParent(dest)) {
                total = total + weight;
                ds.findUnion(source, dest);
            }
        }
        System.out.println(total);
    }

    public static void main(String[] args) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int edges[][] = { { 0, 1, 5 } };
        int vertex = 2;
        createGraph(edges, vertex, pq);
        findMinimumTree(pq, vertex);

    }
}