package recursion.LoveBabbar;

public class ratInMaze {

    public static void findAllPossibleDirection(int arr[][], int visited[][], int total, int row, int column,
            String ans) {

        if (row == total - 1 && column == total - 1) {
            System.out.println("Rat Rich There Destination-->" + ans);
            return;
        }

        // to move down
        if (row < total - 1 && arr[row + 1][column] == 1 && visited[row + 1][column] == 0) {
            visited[row + 1][column] = 1;
            findAllPossibleDirection(arr, visited, total, row + 1, column, ans + 'D');
            visited[row + 1][column] = 0;
        }
        // to upDirection
        if (row > 0 && arr[row - 1][column] == 1 && visited[row - 1][column] == 0) {
            visited[row - 1][column] = 1;
            findAllPossibleDirection(arr, visited, total, row - 1, column, ans + "U");
            visited[row - 1][column] = 0;
        }
        // to righDirection
        if (column < total - 1 && arr[row][column + 1] == 1 && visited[row][column + 1] == 0) {
            visited[row][column + 1] = 1;
            findAllPossibleDirection(arr, visited, total, row, column + 1, ans + "R");
            visited[row][column + 1] = 0;

        }
        // to leftDirection
        if (column > 0 && arr[row][column - 1] == 1 && visited[row][column - 1] == 0) {
            visited[row][column - 1] = 1;
            findAllPossibleDirection(arr, visited, total, row, column - 1, ans + "L");
            visited[row][column - 1] = 0;
        }
        return;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
        int visitedMatrix[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
        int total = 4;
        findAllPossibleDirection(arr, visitedMatrix, total, 0, 0, "");
    }

}
