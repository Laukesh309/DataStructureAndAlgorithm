package recursion;

public class wordSearch {

    public static boolean findAllPath(char board[][], int visitedArray[][], int totalRow, int totalColumn,
            int currentRow,
            int currentColumn, String result, String searchWord) {
        if (currentRow < 0 || currentRow > totalRow - 1) {
            return false;
        }
        if (currentColumn > totalColumn - 1 || currentColumn < 0) {
            return false;
        }
        result = result + board[currentRow][currentColumn];
        if (currentColumn > totalColumn - 1) {
            return findAllPath(board, visitedArray, totalRow, totalColumn, currentRow + 1, 0, result, searchWord);
        }

        if (currentRow == totalRow - 1 && currentColumn == totalColumn - 1) {
            System.out.println(result);
            if (result.contains(searchWord)) {
                return true;
            } else {
                return false;
            }
        }
        if (result.contains(searchWord)) {
            return true;
        }
        if (visitedArray[currentRow][currentColumn] == 1) {
            return false;
        }
        visitedArray[currentRow][currentColumn] = 1;

        // go up
        boolean upResult = findAllPath(board, visitedArray, totalRow, totalColumn, currentRow - 1, currentColumn,
                result, searchWord);
        // go right
        boolean rightResult = findAllPath(board, visitedArray, totalRow, totalColumn, currentRow, currentColumn + 1,
                result, searchWord);
        // go down
        boolean downResult = findAllPath(board, visitedArray, totalRow, totalColumn, currentRow + 1, currentColumn,
                result, searchWord);
        // go left
        boolean leftResult = findAllPath(board, visitedArray, totalRow, totalColumn, currentRow, currentColumn - 1,
                result, searchWord);
        visitedArray[currentRow][currentColumn] = 0;
        return upResult || rightResult || downResult || leftResult;

    }

    public static void main(String[] args) {
        char board[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "SEE";
        int totalRow = board.length;
        int totalColumn = board[0].length;
        int visitedArray[][] = new int[totalRow][totalColumn];
        for (int i = 0; i < visitedArray.length; i++) {
            for (int j = 0; j < visitedArray[0].length; j++) {
                visitedArray[i][j] = 0;
            }

        }
        System.out.println(findAllPath(board, visitedArray, totalRow, totalColumn, 0, 0, "", word));

    }

}
