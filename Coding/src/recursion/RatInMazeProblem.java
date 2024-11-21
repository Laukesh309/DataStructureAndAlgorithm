package recursion;

public class RatInMazeProblem {

    public static void printArray(int path[][]) {
        for (int row = 0; row < path.length; row++) {
            for (int column = 0; column < path.length; column++) {
                System.out.print(path[row][column] + " ");
            }
            System.out.println();
        }
    }

    public static void printAllPath(int path[][], int visited[][], int currentRow, int currentColumn, int N,
            String currentResult) {
        if (currentRow == N && currentColumn == N) {
            System.out.println(currentResult);
            printArray(visited);
            System.out.println("Rat path is exist");
            return;
        }
        if (currentRow < 0 || currentColumn < 0) {
            return;
        }
        if (currentRow > N || currentColumn > N) {
            return;
        }
        if (path[currentRow][currentColumn] == 0) {
            return;
        }
        // move top
        if (visited[currentRow][currentColumn] == 1) {
            return;
        }
        ////
        visited[currentRow][currentColumn] = 1;
        printAllPath(path, visited, currentRow - 1, currentColumn, N, currentResult + "U");
        printAllPath(path, visited, currentRow, currentColumn - 1, N, currentResult + "L");
        printAllPath(path, visited, currentRow + 1, currentColumn, N, currentResult + "D");
        printAllPath(path, visited, currentRow, currentColumn + 1, N, currentResult + "R");
        visited[currentRow][currentColumn] = 0;
        return;

    }

    public static void main(String[] args) {
        int path[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
        int n = 4;
        int visited[][] = new int[4][4];
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                visited[row][column] = 0;
            }
        }
        printAllPath(path, visited, 0, 0, n - 1, "");
    }

}
