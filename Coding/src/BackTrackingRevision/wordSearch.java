package BackTrackingRevision;

public class wordSearch {

    public static boolean findWord(char board[][], int currentRow, int currentColumn, int currentWordIndex,
            String word, boolean visited[][]) {
        if (currentWordIndex >= word.length()) {
            return true;
        }
        if (currentColumn < 0 || currentRow < 0 || currentRow > board.length - 1
                || currentColumn > board[0].length - 1 || visited[currentRow][currentColumn] == true) {
            return false;
        }

        if (board[currentRow][currentColumn] == word.charAt(currentWordIndex)) {
            visited[currentRow][currentColumn] = true;
            boolean left = findWord(board, currentRow, currentColumn - 1, currentWordIndex + 1, word, visited);
            boolean right = findWord(board, currentRow, currentColumn + 1, currentWordIndex + 1, word, visited);
            boolean top = findWord(board, currentRow - 1, currentColumn, currentWordIndex + 1, word, visited);
            boolean bottom = findWord(board, currentRow + 1, currentColumn, currentWordIndex + 1, word, visited);
            visited[currentRow][currentColumn] = false;
            return left || right || top || bottom;

        }
        return false;
    }

    public static void main(String[] args) {
        String board[][] = { { 'A', "B", "C", "E" }, { "S", "F", "C", "S" }, { "A", "D", "E", "E" } };
        String word = "ABCCED";
        boolean visited[][] = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (findWord(board, i, j, 0, word, visited)) {

                }
            }
        }

    }

}
