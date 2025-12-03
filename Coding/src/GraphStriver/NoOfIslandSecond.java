package GraphStriver;

import java.util.ArrayList;
import java.util.List;

class DisJointSet5 {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisJointSet5(int vertex) {
        for (int i = 0; i < vertex; i++) {
            parent.add(i);
            rank.add(0);
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
            parent.set(uParent, parent.get(vParent));
        } else if (rank.get(uParent) > rank.get(vParent)) {
            parent.set(vParent, parent.get(uParent));
        } else {
            parent.set(uParent, vParent);
            rank.set(vParent, rank.get(vParent) + 1);
        }
    }

}

public class NoOfIslandSecond {
    public static void printArray(int matrix[][]) {
        for (int[] is : matrix) {
            for (int is2 : is) {
                System.out.print(is2 + " ");
            }
            System.out.println();
        }
    }

    public static void findNoOfIsland(int[][] operators, int rows, int cols) {
        int tatalVertex = rows * cols;
        int matrix[][] = new int[rows][cols];
        boolean visited[][] = new boolean[rows][cols];
        DisJointSet5 ds = new DisJointSet5(tatalVertex);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < operators.length; i++) {
            int cRow = operators[i][0];
            int cCol = operators[i][1];
            int vertex = cRow * cols + cCol;
            int detlaRow[] = { 0, 0, 1, -1 };
            int deltaCol[] = { 1, -1, 0, 0 };
            int currCount = result.get(result.size() - 1);
            matrix[cRow][cCol] = 1;
            if (!visited[cRow][cCol]) {

                currCount += 1;

                for (int j = 0; j < 4; j++) {
                    int dRow = cRow + detlaRow[j];
                    int dCol = cCol + deltaCol[j];
                    if (dRow >= 0 && dCol >= 0 && dRow < rows && dCol < cols && matrix[dRow][dCol] == 1) {
                        int tempVertex = dRow * cols + dCol;
                        System.out.println(tempVertex + " " + vertex);
                        // if (cRow == 1 && cCol == 2) {
                        // System.out.println(
                        // dRow + " " + dCol + " " + ds.findParent(tempVertex) + " " +
                        // ds.findParent(vertex));
                        // // printArray(matrix);
                        // }
                        if (ds.findParent(tempVertex) != ds.findParent(vertex)) {

                            currCount--;
                            ds.findUnioun(vertex, tempVertex);
                        }
                    }
                }
            }
            visited[cRow][cCol] = true;
            result.add(currCount);
            System.out.println(ds.parent);
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int rows = 2;
        int cols = 4;
        int[][] operators = { { 1, 3 }, { 0, 3 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, 2 }, { 0, 3 }, { 1, 2 } };
        findNoOfIsland(operators, rows, cols);

    }

}
