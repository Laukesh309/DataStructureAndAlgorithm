package GraphStriver;

import java.util.List;
import java.util.ArrayList;

class DisjointSet3 {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet3(int vertex) {
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

    public void findUnioun(int u, int v) {
        int uParent = findParent(u);
        int vParent = findParent(v);
        if (uParent == vParent) {
            return;
        }
        if (rank.get(uParent) < rank.get(vParent)) {
            parent.set(uParent, vParent);
        } else if (rank.get(uParent) > rank.get(vParent)) {
            parent.set(vParent, uParent);
        } else {
            parent.set(uParent, vParent);
            rank.set(vParent, rank.get(vParent) + 1);
        }
    }
}

public class connectingGraph {

    public static void checkMinimum(int edges[][], int vertex) {
        DisjointSet3 ds = new DisjointSet3(vertex);
        int extra = 0;
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            System.out.println("this is source" + source);
            if (ds.findParent(source) == ds.findParent(dest)) {
                extra++;
            }
            ds.findUnioun(source, dest);
        }
        int count = 0;
        for (int i = 0; i < ds.parent.size(); i++) {
            if (i == ds.parent.get(i)) {
                count++;
            }
        }
        if (count - 1 <= extra) {
            System.out.println(count - 1);
        }
        System.out.println(-1);
    }

    public static void main(String[] args) {
        int edges[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        int vertex = 4;
        checkMinimum(edges, vertex);
    }

}
