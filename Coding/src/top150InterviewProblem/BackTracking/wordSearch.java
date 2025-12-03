package top150InterviewProblem.BackTracking;

public class wordSearch {

    public static boolean isExist(char board[][], String str, boolean visited[][], int currentRow, int currentColumn,
            int currentIndex) {
        if (currentIndex >= str.length()) {
            return true;
        }
        if (currentRow >= board.length || currentColumn >= board[0].length || currentRow < 0 || currentColumn < 0
                || visited[currentRow][currentColumn]) {
            return false;
        }

        if (board[currentRow][currentColumn] == str.charAt(currentIndex)) {
            visited[currentRow][currentColumn] = true;
            boolean top = isExist(board, str, visited, currentRow - 1, currentColumn, currentIndex + 1);
            boolean right = isExist(board, str, visited, currentRow, currentColumn + 1, currentIndex + 1);
            boolean left = isExist(board, str, visited, currentRow, currentColumn - 1, currentIndex + 1);
            boolean down = isExist(board, str, visited, currentRow + 1, currentColumn, currentIndex + 1);
            visited[currentRow][currentColumn] = false;
            return top || right || left || down;
        }
        return false;
    }

    public static boolean findIsWordExist(char board[][], String str, boolean visited[][]) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (isExist(board, str, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        char board[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String str = "ABCCED";
        boolean visited[][] = new boolean[board.length][board.length];

        System.out.println(findIsWordExist(board, str, visited));
    }

}
