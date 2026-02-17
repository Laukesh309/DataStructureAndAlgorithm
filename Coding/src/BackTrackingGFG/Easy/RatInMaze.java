package BackTrackingGFG.Easy;

public class RatInMaze {

    public static void printAllPath(int mat[][], int row, int column, String result, boolean visited[][]) {
        int rowLength = mat.length;
        int colLength = mat.length;
        if (row >= rowLength || column >= colLength || row < 0 || column < 0 || visited[row][column]
                || mat[row][column] == 0) {
            return;
        }
        if (row == rowLength - 1 && column == colLength - 1) {
            System.out.println(result);
            return;
        }
        visited[row][column] = true;
        printAllPath(mat, row - 1, column, result + 'U', visited);
        printAllPath(mat, row + 1, column, result + 'D', visited);
        printAllPath(mat, row, column + 1, result + 'R', visited);
        printAllPath(mat, row, column, result + 'L', visited);
        visited[row][column] = false;
    }

    public static void main(String[] args) {
        int mat[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
        boolean visited[][] = new boolean[mat.length][mat.length];
        printAllPath(mat, 0, 0, new String(), visited);

    }

}
