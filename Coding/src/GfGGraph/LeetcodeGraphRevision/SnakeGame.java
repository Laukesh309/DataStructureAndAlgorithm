package GfGGraph.LeetcodeGraphRevision;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeGame {

    public static void main(String[] args) {
        int board[][] = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };

        int boardSize = board.length;
        int lastRow = boardSize - 1;
        int lastCol = boardSize - 1;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        boolean visited[][] = new boolean[boardSize][boardSize];
        int totalStep = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int row = 0; row < size; row++) {
                int currentIndex = que.poll();
                if (currentIndex == boardSize * boardSize - 1) {
                    System.out.println(totalStep);
                    return;
                }
                for (int i = 1; i <= 6; i++) {
                    int nextIndex = currentIndex + i;
                    if (nextIndex >= boardSize * boardSize) {
                        continue;
                    }
                    int quatiant = nextIndex / boardSize;
                    int remainder = nextIndex % boardSize;
                    int currentRow = lastRow - quatiant;
                    int currentCol = quatiant % 2 == 0 ? remainder : lastCol - remainder;
                    if (board[currentRow][currentCol] != -1) {
                        nextIndex = board[currentRow][currentCol] - 1;
                        quatiant = nextIndex / boardSize;
                        remainder = nextIndex % boardSize;
                        currentRow = lastRow - quatiant;
                        currentCol = quatiant % 2 == 0 ? remainder : lastCol - remainder;
                    }
                    if (!visited[currentRow][currentCol]) {
                        visited[currentRow][currentCol] = true;
                        que.add(nextIndex);
                    }
                }
            }
            totalStep++;

        }
    }

}
