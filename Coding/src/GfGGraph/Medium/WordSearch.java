package GfGGraph.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordSearch {

    public static boolean checkMatchingChar(char board[][], int row, int col, int currentIndex, int wordSize,
            boolean visited[][], String word) {

        if (board[row][col] != word.charAt(currentIndex)) {
            return false;
        }
        if (currentIndex == wordSize - 1) {
            return true;
        }
        int deltaRow[] = { 1, -1, 0, 0 };
        int deltaCol[] = { 0, 0, 1, -1 };
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nextRow = row + deltaRow[i];
            int nextCol = col + deltaCol[i];
            if (nextRow >= 0 && nextCol >= 0 && nextRow < board.length && nextCol < board[0].length
                    && !visited[nextRow][nextCol]) {
                if (checkMatchingChar(board, nextRow, nextCol, currentIndex + 1, wordSize, visited, word)) {

                    visited[row][col] = false;

                    return true;
                }
            }
        }
        visited[row][col] = false;
        return false;

    }

    public static ArrayList<String> findAllString(char board[][], String words[]) {

        int rowSize = board.length;
        int colSize = board[0].length;

        ArrayList<String> result = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            hs.add(words[i]);
        }

        for (String curString : hs) {
            boolean found = false;
            for (int row = 0; row < rowSize && !found; row++) {
                for (int col = 0; col < colSize && !found; col++) {
                    if (board[row][col] == curString.charAt(0)) {
                        boolean visited[][] = new boolean[rowSize][colSize];
                        if (checkMatchingChar(board, row, col, 0, curString.length(), visited, curString)) {
                            result.add(curString);
                            found = true;
                        }
                    }
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        char board[][] = { { 'p',
                'n',
                'h',
                'a' } };
        String words[] = { "ahnp", "faoikn", "shon", "rztpjrxhr", "ebns", "bbcirfbxbrhu", "yrx", "qsulunxstq" };
        System.out.println(findAllString(board, words));
    }
}
