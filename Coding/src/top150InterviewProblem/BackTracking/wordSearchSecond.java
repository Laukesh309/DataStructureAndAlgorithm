package top150InterviewProblem.BackTracking;

public class wordSearchSecond {

    public static boolean searchWord(char[][] board, boolean visited[][], int currentRow, int currentCol, String word,
            int currentIndex) {
        if (currentIndex >= word.length()) {
            return true;
        }
        if (currentRow >= board.length || currentCol >= board[0].length || currentRow < 0 || currentCol < 0
                || visited[currentRow][currentCol] || board[currentRow][currentCol] != word.charAt(currentIndex)) {
            return false;
        }
        visited[currentRow][currentCol] = true;
        boolean top = searchWord(board, visited, currentRow - 1, currentCol, word, currentIndex + 1);
        boolean bottom = searchWord(board, visited, currentRow + 1, currentCol, word, currentIndex + 1);
        boolean left = searchWord(board, visited, currentRow, currentCol - 1, word, currentIndex + 1);
        boolean right = searchWord(board, visited, currentRow, currentCol + 1, word, currentIndex + 1);
        return top || bottom || left || right;

    }

    public static boolean wordSearch(char[][] board, String word) {
        int totalRow = board.length;
        int totalCol = board[0].length;
        boolean visited[][] = new boolean[totalRow][totalCol];
        for (int row = 0; row < totalRow; row++) {
            for (int col = 0; col < totalCol; col++) {
                if (board[row][col] == word.charAt(0) && searchWord(board, visited, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word = "ABCCED";
        System.out.println(wordSearch(board, word));
    }

}
