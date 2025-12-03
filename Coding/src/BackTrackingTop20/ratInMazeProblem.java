package BackTrackingTop20;

import java.util.ArrayList;
import java.util.Collections;

public class ratInMazeProblem {

    public static void findAllPath(int[][] maze, int sourceRow, int sourceColumn, ArrayList<String> finalResult,
            String path) {
        if (sourceRow == maze.length - 1 && sourceColumn == maze[0].length - 1) {
            finalResult.add(path);
            return;
        }
        String tempPath = "DURL";
        int deltaRow[] = { 1, -1, 0, 0 };
        int deltaColumn[] = { 0, 0, 1, -1 };
        maze[sourceRow][sourceColumn] = 0;
        for (int i = 0; i < 4; i++) {
            int row = sourceRow + deltaRow[i];
            int column = sourceColumn + deltaColumn[i];
            System.out.println(row + " " + column);
            if (row >= 0 && column >= 0 && row < maze.length && column < maze.length && maze[row][column] == 1) {
                maze[sourceRow][sourceColumn] = 0;
                findAllPath(maze, row, column, finalResult, path + tempPath.charAt(i));
            }
        }
        maze[sourceRow][sourceColumn] = 1;

    }

    public static void main(String[] args) {
        int[][] maze = {
                { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 }
        };

        ArrayList<String> result = new ArrayList<>();
        findAllPath(maze, 0, 0, result, "");
        Collections.sort(result);
        System.out.println(result);
    }

}
