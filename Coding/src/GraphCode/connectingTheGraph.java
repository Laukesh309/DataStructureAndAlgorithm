package GraphCode;

import java.util.List;

import java.util.ArrayList;

public class connectingTheGraph {

    static class DisJointSet3 {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisJointSet3(int v) {
            for (int i = 0; i < v; i++) {
                parent.add(i);
                size.add(0);
            }
        }

        public int findParent(int n) {
            if (n == parent.get(n)) {
                return n;
            }
            int tempParent = findParent(parent.get(n));
            parent.set(n, tempParent);
            return tempParent;
        }

        public void findUnioun(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (pu != pv) {
                if (size.get(pu) < size.get(pv)) {
                    size.set(pv, size.get(pu) + size.get(pv) + 1);
                    parent.set(pu, pv);
                } else if (size.get(pu) > size.get(pv)) {
                    size.set(pu, size.get(pu) + size.get(pv) + 1);
                    parent.set(pv, pu);
                } else {
                    size.set(pu, size.get(pu) + size.get(pv) + 1);
                    parent.set(pv, pu);
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int Edges[][] = { { 7, 4 }, { 2, 7 }, { 7, 9 }, { 3, 1 }, { 9, 8 }, { 6, 5 }, { 0, 2 }, { 8, 6 }, { 0, 2 } };

        DisJointSet3 ds = new DisJointSet3(n);
        for (int i = 0; i < Edges.length; i++) {
            int source = Edges[i][0];
            int dest = Edges[i][1];
            ds.findUnioun(source, dest);
        }

    }

}
