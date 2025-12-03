package GraphStriver;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUParent(int n) {
        if (parent.get(n) == n) {
            return n;
        }
        int curParent = findUParent(parent.get(n));
        parent.set(n, curParent);
        return parent.get(n);
    }

    public void uniounByRank(int u, int v) {
        int uParent = findUParent(u);
        int vParent = findUParent(v);
        if (uParent == vParent) {
            return;
        }
        if (rank.get(uParent) < rank.get(vParent)) {
            parent.set(uParent, vParent);

        } else if (rank.get(vParent) < rank.get(uParent)) {
            parent.set(vParent, uParent);
        } else {
            parent.set(uParent, vParent);
            int tempRank = rank.get(vParent);
            rank.set(vParent, tempRank + 1);
        }
    }

    public static void main(String[] args) {
        int n = 8;
        DisjointSet ds = new DisjointSet(n);
        ds.uniounByRank(1, 2);
        ds.uniounByRank(2, 3);
        ds.uniounByRank(4, 5);
        ds.uniounByRank(6, 7);
        ds.uniounByRank(5, 6);
        System.out.println(ds.parent);
        System.out.println(ds.rank);
        // System.out.println(ds.findUParent(6) + " " + ds.findUParent(3));
        ds.uniounByRank(2, 7);
        System.out.println(ds.parent);
        System.out.println(ds.findUParent(4));
        System.out.println(ds.parent);
        System.out.println(ds.findUParent(1));
        System.out.println(ds.parent);
    }

}
