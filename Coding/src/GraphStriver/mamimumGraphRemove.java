package GraphStriver;

import java.util.*;
import java.util.ArrayList;

class DisjointSet8 {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet8(int vertex) {
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
        } else if (rank.get(uParent) < rank.get(vParent)) {
            parent.set(uParent, vParent);
        } else if (rank.get(uParent) > rank.get(vParent)) {
            parent.set(vParent, uParent);
        } else {
            parent.set(uParent, vParent);
            rank.set(vParent, rank.get(vParent) + 1);
        }
    }
}

public class mamimumGraphRemove {

    public static void findTotalRemoval(int stones[][], int n) {

        int maxRow = Integer.MIN_VALUE;
        int maxColumn = Integer.MIN_VALUE;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxColumn = Math.max(maxColumn, stones[i][1]);
        }
        int totalNode = maxRow + maxColumn + 2;
        DisjointSet8 ds = new DisjointSet8(totalNode);
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < stones.length; i++) {
            int row = stones[i][0];
            int col = stones[i][1];
            int rowNode = row;
            int colNode = maxRow + 1 + col;
            if (ds.findParent(rowNode) != ds.findParent(colNode)) {
                ds.findUnioun(rowNode, colNode);
                hs.add(rowNode);
                hs.add(colNode);
            }
        }
        int totalCount = 0;
        for (Integer integer : hs) {
            if (integer == ds.findParent(integer)) {
                totalCount++;
            }
        }
        int result = stones.length - totalCount;
        System.out.println(result);

    }

    public static void main(String[] args) {
        int n = 3;
        int stones[][] = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
        findTotalRemoval(stones, n);

    }

}
