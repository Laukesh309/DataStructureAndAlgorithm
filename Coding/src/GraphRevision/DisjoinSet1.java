package GraphRevision;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DisjoinSet1 {

    static class Pair implements Comparable<Pair> {
        int source;
        int dest;
        int weight;

        Pair(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Pair p2) {
            return this.weight - p2.weight;
        }

    }

    static class DisJoint {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisJoint(int v) {
            for (int i = 0; i < v; i++) {
                rank.add(0);
                parent.add(i);
            }
        }

        public int findParent(int n) {
            if (n == parent.get(n)) {
                return n;
            }
            int pn = findParent(parent.get(n));
            parent.set(n, pn);
            return pn;
        }

        public void findUnioun(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (rank.get(pu) < rank.get(pv)) {
                parent.set(pu, parent.get(pv));
            } else if (rank.get(pu) > rank.get(pv)) {
                parent.set(pv, parent.get(pu));
            } else {
                parent.set(pu, parent.get(pv));
                rank.set(pv, rank.get(pv) + 1);

            }
        }
    }

    public static int findMinSpanningTree(int V, int edges[][]) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        DisJoint ds = new DisJoint(V);
        int totalSum = 0;
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            int weight = edges[i][2];
            pq.add(new Pair(source, dest, weight));
        }
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int source = pair.source;
            int dest = pair.dest;
            int weight = pair.weight;
            int pu = ds.findParent(source);
            int pv = ds.findParent(dest);
            if (pu != pv) {
                totalSum = totalSum + weight;
                ds.findUnioun(source, dest);
            }
        }
        System.out.println(totalSum);
        return totalSum;
    }

    public static void main(String[] args) {
        int V = 3, E = 3;
        int edges[][] = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };
        findMinSpanningTree(V, edges);

    }
}
