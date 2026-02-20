package GfGGraph.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class kruskalAlgo {
    static class DisjointSet {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        DisjointSet(int V) {
            for (int i = 0; i < V; i++) {
                parent.add(i);
                rank.add(1);
            }
        }

        public int findParent(int x) {
            if (parent.get(x) == x) {
                return x;
            }
            int par = findParent(parent.get(x));
            parent.set(x, par);
            return par;
        }

        public void findUnioun(int x, int y) {
            int xParent = findParent(x);
            int yParent = findParent(y);
            if (xParent != yParent) {
                if (rank.get(xParent) > rank.get(yParent)) {
                    parent.set(yParent, xParent);
                } else if (rank.get(yParent) > rank.get(xParent)) {
                    parent.set(xParent, yParent);
                } else {
                    parent.set(yParent, xParent);
                    rank.set(xParent, rank.get(xParent) + 1);
                }
            }

        }
    }

    static class Pair implements Comparable<Pair> {
        int source;
        int dest;
        int cast;

        Pair(int source, int dest, int cast) {
            this.source = source;
            this.dest = dest;
            this.cast = cast;
        }

        public int compareTo(Pair p2) {
            return this.cast - p2.cast;
        }
    }

    public static int findMinCast(int edges[][], int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        DisjointSet ds = new DisjointSet(V);
        for (int i = 0; i < edges.length; i++) {
            pq.add(new Pair(edges[i][0], edges[i][1], edges[i][2]));
        }
        int totalCast = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int source = pair.source;
            int dest = pair.dest;
            int cast = pair.cast;
            if (ds.findParent(source) != ds.findParent(dest)) {
                totalCast += cast;
                ds.findUnioun(source, dest);
            }
        }
        return totalCast;

    }

    public static void main(String[] args) {
        int V = 2;
        int edges[][] = { { 0, 1, 5 } };
        System.out.println(findMinCast(edges, V));

    }

}
