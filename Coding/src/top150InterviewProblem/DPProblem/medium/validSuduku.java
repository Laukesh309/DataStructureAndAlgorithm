package top150InterviewProblem.DPProblem.medium;

public class validSuduku {

    public static boolean isValid(char board[][], int sourceRow, int sourceColumn, int destinationRow,
            int destinationColumn,
            char value) {
        //// check in row
        for (int column = 0; column <= destinationColumn; column++) {
            if (board[sourceRow][column] == value) {
                return false;
            }
        }
        /// check in column
        for (int row = 0; row <= destinationRow; row++) {
            if (board[row][sourceColumn] == value) {
                return false;
            }
        }
        /// check in rectangle;
        int startRow = (sourceRow / 3) * 3;
        int startColumn = (sourceColumn / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColumn; j < startColumn + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean isValidSuduku(char board[][], int sourceRow, int sourceColumn, int destinationRow,
            int destinationColumn) {
        if (sourceRow > destinationRow) {
            return true;
        }
        if (sourceColumn > destinationColumn) {
            return isValidSuduku(board, sourceRow + 1, 0, destinationRow,
                    destinationColumn);
        }
        if (board[sourceRow][sourceColumn] == '.') {
            return isValidSuduku(board, sourceRow, sourceColumn + 1, destinationRow,
                    destinationColumn);
        } else {
            char value = board[sourceRow][sourceColumn];
            board[sourceRow][sourceColumn] = '.';
            if (isValid(board, sourceRow, sourceColumn, destinationRow, destinationColumn, value)) {
                board[sourceRow][sourceColumn] = value;
                return isValidSuduku(board, sourceRow, sourceColumn + 1, destinationRow, destinationColumn);

            } else {
                return false;
            }
        }

    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        // System.out.println(findIsValid(board, 0, 0, 8, 8));
        System.out.println(isValidSuduku(board, 0, 0, 8, 8));
    }

}
