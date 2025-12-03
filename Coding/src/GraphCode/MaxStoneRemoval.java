package GraphCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxStoneRemoval {

    static class DisjointSet10 {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        DisjointSet10(int v) {
            for (int i = 0; i < v; i++) {
                parent.add(i);
                rank.add(0);
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
                if (rank.get(pu) < rank.get(pv)) {
                    parent.set(pu, pv);
                } else if (rank.get(pv) < rank.get(pu)) {
                    parent.set(pv, pu);
                } else {
                    parent.set(pu, pv);
                    rank.set(pv, rank.get(pv) + 1);
                }
            }
        }
    }

    public static void findMaxStoneRemoval(int stones[][]) {
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(stones[i][0], maxRow);
            maxCol = Math.max(stones[i][1], maxCol);
        }
        int totalVertex = maxRow + maxCol + 2;
        System.out.println(totalVertex);
        DisjointSet10 ds = new DisjointSet10(totalVertex);
        for (int i = 0; i < stones.length; i++) {
            int curRow = stones[i][0];
            int curCol = stones[i][1];
            ds.findUnioun(curRow, maxRow + curCol + 1);
        }
        Set<Integer> result = new HashSet<>();
        int colOffset = maxRow + 1;
        for (int i = 0; i < stones.length; i++) {
            int curRow = stones[i][0];
            int curCol = stones[i][1] + colOffset;
            result.add(ds.findParent(curRow));
            result.add(ds.findParent(curCol));
        }
        int total = stones.length - result.size();
        System.out.println(total);

    }

    public static void main(String[] args) {
        int stones[][] = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
        findMaxStoneRemoval(stones);

    }

}
