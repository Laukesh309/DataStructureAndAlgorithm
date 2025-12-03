package GraphRevision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class noofIslandsecond {

    static class DisjointSet5 {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet5(int v) {
            for (int i = 0; i < v; i++) {
                rank.add(0);
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
            if (rank.get(pu) < rank.get(pv)) {
                parent.set(pu, pv);
            } else if (rank.get(pu) > rank.get(pv)) {
                parent.set(pv, pu);
            } else {
                parent.set(pu, pv);
                rank.set(pv, rank.get(pv) + 1);
            }
        }
    }

    public static void findIsland(int matrix[][], int operators[][], int n, int m) {
        DisjointSet5 ds = new DisjointSet5(m * n);
        ArrayList<Integer> finalResult = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            matrix[row][col] = 1;
            int curVertex = m * row + col;
            int deltaRow[] = { 1, -1, 0, 0 };
            int deltaCol[] = { 0, 0, 1, -1 };
            for (int j = 0; j < 4; j++) {
                int curRow = row + deltaRow[j];
                int curCol = col + deltaCol[j];
                if (curRow >= 0 && curCol >= 0 && curRow < n && curCol < m && matrix[curRow][curCol] == 1) {
                    int nexVertex = curRow * m + curCol;
                    System.out.println("next vertex" + nexVertex);
                    ds.findUnioun(curVertex, nexVertex);
                }
            }
            Set<Integer> result = new HashSet<>();
            for (int k = 0; k <= i; k++) {
                int tempRow = operators[k][0];
                int tempCol = operators[k][1];
                int curVertex1 = m * tempRow + tempCol;
                int tempResult = ds.findParent(curVertex1);
                result.add(tempResult);
            }
            finalResult.add(result.size());
        }
        return finalResult;

    }

    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int k = 4;
        int[][] operators = { { 1, 1 }, { 0, 1 }, { 3, 3 }, { 3, 4 } };
        int matrix[][] = new int[n][m];
        findIsland(matrix, operators, n, m);
    }

}
