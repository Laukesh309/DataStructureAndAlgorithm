package GraphRevision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class maxConnectedGraph {
    static class DisjointSet6 {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet6(int v) {
            for (int i = 0; i < v; i++) {
                size.add(1);
                parent.add(i);
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
                    parent.set(pu, pv);
                    size.set(pv, size.get(pv) + size.get(pu));
                } else if (size.get(pu) > size.get(pv)) {
                    parent.set(pv, pu);
                    size.set(pu, size.get(pu) + size.get(pv));
                } else {
                    parent.set(pu, pv);
                    size.set(pv, size.get(pu) + size.get(pv));
                }

            }

        }
    }

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void findMaxIsland(int grid[][]) {
        Queue<Pair> que = new LinkedList<>();
        DisjointSet6 ds = new DisjointSet6(grid.length * grid[0].length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int row = i;
                int col = j;
                if (grid[i][j] == 1) {
                    int curVertex = row * grid.length + col;
                    int deltaRow[] = { 1, -1, 0, 0 };
                    int deltaCol[] = { 0, 0, 1, -1 };
                    for (int k = 0; k < 4; k++) {
                        int curRow = row + deltaRow[k];
                        int curCol = col + deltaCol[k];
                        if (curRow >= 0 && curCol >= 0 && curRow < grid.length && curCol < grid[0].length
                                && grid[curRow][curCol] == 1) {
                            int nextVertex = curRow * grid.length + curCol;
                            ds.findUnioun(curVertex, nextVertex);

                        }
                    }
                } else {
                    que.add(new Pair(row, col));
                }

            }
        }
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < ds.size.size(); i++) {
            maxCount = Math.max(maxCount, ds.size.get(i));
        }
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            int row = pair.row;
            int col = pair.col;
            int deltaRow[] = { 1, -1, 0, 0 };
            int deltaCol[] = { 0, 0, 1, -1 };
            Set<Integer> tempResult = new HashSet<>();
            for (int i = 0; i < 4; i++) {
                int curRow = row + deltaRow[i];
                int curCol = col + deltaCol[i];
                if (curRow >= 0 && curCol >= 0 && curRow < grid.length && curCol < grid[0].length
                        && grid[curRow][curCol] == 1) {
                    int vertex = curRow * grid.length + curCol;
                    tempResult.add(ds.findParent(vertex));
                }
            }
            int tempCount = 0;
            for (Integer integer : tempResult) {
                tempCount += ds.size.get(integer);
            }
            maxCount = Math.max(maxCount, tempCount + 1);
        }
        System.out.println(maxCount);
    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 1 },
                { 0, 1 } };
        findMaxIsland(grid);

    }

}
