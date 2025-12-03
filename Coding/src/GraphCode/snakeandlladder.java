package GraphCode;

import java.util.LinkedList;
import java.util.Queue;

public class snakeandlladder {
    static class Pair {
        int dest;
        int count;

        Pair(int dest, int count) {
            this.dest = dest;
            this.count = count;
        }
    }

    public static void findMinPath(int board[][]) {
        Queue<Pair> que = new LinkedList<>();
        int totalLenght = board.length;
        int totalWays = Math.min(totalLenght * totalLenght, 6);
        que.add(new Pair(0, 0));
        boolean visited[] = new boolean[totalLenght * totalLenght];
        visited[0] = true;

        while (!que.isEmpty()) {
            Pair pair = que.poll();
            int currentVertex = pair.dest;
            int currentCount = pair.count;
            if (currentVertex == totalLenght * totalLenght - 1) {
                System.out.println("currentVertex-->" + currentCount);
                return;
            }
            for (int i = 1; i <= 6; i++) {
                int nextVertex = currentVertex + i;
                if (nextVertex < totalLenght * totalLenght && !visited[nextVertex]) {
                    System.out.println(nextVertex);
                    int row = nextVertex / totalLenght;
                    int col = nextVertex % totalLenght;
                    int realRow = totalLenght - 1 - row;
                    int realCol = (row % 2 == 0) ? col : (totalLenght - 1 - col);
                    if (board[realRow][realCol] != -1) {
                        nextVertex = board[realRow][realCol] - 1;
                    }
                    visited[nextVertex] = true;
                    que.add(new Pair(nextVertex, currentCount + 1));

                }

            }

        }
    }

    public static void main(String[] args) {
        int board[][] = { { 1, 1, -1 }, { 1, 1, 1 }, { -1, 1, 1 } };
        findMinPath(board);

    }

}
