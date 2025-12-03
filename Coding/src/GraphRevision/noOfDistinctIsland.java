package GraphRevision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import HashSet.hashSet;

public class noOfDistinctIsland {

    static class Pair {
        int row;
        int column;

        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static void findDistinctIsland(int grid[][], int sourceRow, int sourceColumn, boolean visited[][],
            Set<ArrayList<ArrayList<Integer>>> result) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(sourceRow, sourceColumn));
        visited[sourceRow][sourceColumn] = true;
        ArrayList<Integer> tempResult = new ArrayList<>();
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        tempResult.add(0);
        tempResult.add(0);
        finalResult.add(tempResult);
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            int row = pair.row;
            int col = pair.column;
            int deltaRow[] = { 1, -1, 0, 0 };
            int deltaCol[] = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int curRow = row + deltaRow[i];
                int curCol = col + deltaCol[i];
                if (curRow >= 0 && curCol >= 0 && curRow < grid.length && curCol < grid[0].length
                        && grid[curRow][curCol] == 1 && visited[curRow][curCol] == false) {

                    que.add(new Pair(curRow, curCol));
                    visited[curRow][curCol] = true;
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(curRow - sourceRow);
                    temp.add(curCol - sourceColumn);
                    finalResult.add(temp);

                }
            }

        }
        result.add(finalResult);

    }

    public static void main(String[] args) {
        int grid[][] = {
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 1, 1 }
        };
        ;

        boolean visited[][] = new boolean[grid.length][grid[0].length];
        Set<ArrayList<ArrayList<Integer>>> result = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    findDistinctIsland(grid, i, j, visited, result);
                }
            }
        }
        System.out.println(result.size());

    }

}
