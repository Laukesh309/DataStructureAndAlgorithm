package GraphStriver;

import java.util.List;
import java.util.Set;

import java.util.HashSet;

import java.util.ArrayList;

class DisJointSet6 {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisJointSet6(int vertex) {
        for (int i = 0; i < vertex; i++) {
            size.add(1);
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

    public void findUniounBySize(int u, int v) {
        int uParent = findParent(u);
        int vParent = findParent(v);
        if (uParent == vParent) {
            return;
        } else if (size.get(uParent) < size.get(vParent)) {
            parent.set(uParent, vParent);
            size.set(vParent, size.get(vParent) + size.get(uParent));
        } else {
            parent.set(vParent, uParent);
            size.set(uParent, size.get(vParent) + size.get(uParent));
        }
    }
}

public class makingLargeIsland {

    public static void findMinIsland(int grid[][]) {
        int row = grid.length;
        int column = grid.length;
        int totalVertex = row * column;
        DisJointSet6 ds = new DisJointSet6(totalVertex);
        int maxSize = Integer.MIN_VALUE;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    int currentVertex = i * column + j;
                    int deltaRow[] = { 1, -1, 0, 0 };
                    int deltaCol[] = { 0, 0, 1, -1 };
                    for (int k = 0; k < 4; k++) {
                        int cRow = i + deltaRow[k];
                        int cCol = j + deltaCol[k];
                        if (cRow < row && cCol < column && cRow >= 0 && cCol >= 0 && grid[cRow][cCol] == 1) {
                            int tempVertex = cRow * column + cCol;
                            ds.findUniounBySize(currentVertex, tempVertex);
                        }
                    }
                    maxSize = Math.max(maxSize, ds.size.get(ds.findParent(currentVertex)));
                }
            }
        }
        System.out.println(ds.size);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 0) {
                    int deltaRow[] = { 1, -1, 0, 0 };
                    int deltaCol[] = { 0, 0, 1, -1 };
                    Set<Integer> hs = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int cRow = i + deltaRow[k];
                        int cCol = j + deltaCol[k];
                        if (cRow >= 0 && cCol >= 0 && cRow < row && cCol < column && grid[cRow][cCol] == 1) {
                            int vertex = cRow * column + cCol;
                            hs.add(ds.findParent(vertex));
                        }
                    }
                    int totalSize = 1;
                    for (Integer integer : hs) {
                        totalSize = totalSize + ds.size.get(integer);
                    }
                    maxSize = Math.max(maxSize, totalSize);

                }
            }
        }

        System.out.println(maxSize);
    }

    public static void main(String[] args) {
        int grid[][] = { { 1, 1 }, { 1, 1 }, };
        findMinIsland(grid);

    }

}
