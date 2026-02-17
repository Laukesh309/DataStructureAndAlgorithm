package GfGGraph.Easy;

import java.util.LinkedList;
import java.util.Queue;

import HeapChapter.nearByCar;

public class FloodFillAlgo {

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void printImage(int images[][]) {
        for (int[] is : images) {
            for (int is2 : is) {
                System.out.print(is2 + " ");

            }
            System.out.println();
        }
    }

    public static void findConnected(int images[][], int sr, int sc, int newcolor) {

        boolean visited[][] = new boolean[images.length][images[0].length];
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(sr, sc));
        int originalColor = images[sr][sc];
        visited[sr][sc] = true;
        images[sr][sc] = newcolor;
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            int currentRow = pair.row;
            int currentCol = pair.col;
            int deltaRow[] = { 1, -1, 0, 0 };
            int deltaCol[] = { 0, 0, 1, -1 };
            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + deltaRow[i];
                int nextCol = currentCol + deltaCol[i];
                if (nextRow >= 0 && nextRow < images.length && nextCol >= 0 && nextCol < images[0].length
                        && visited[nextRow][nextCol] == false && images[nextRow][nextCol] == originalColor) {
                    que.add(new Pair(nextRow, nextCol));
                    images[nextRow][nextCol] = newcolor;
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }

    public static void fillFlood(int images[][], int currentRow, int currentCol, int newColor, int oldColor) {
        if (currentRow < 0 || currentCol < 0
                || currentRow >= images.length || currentCol >= images[0].length
                || images[currentRow][currentCol] != oldColor) {
            return;
        }
        images[currentRow][currentCol] = newColor;
        fillFlood(images, currentRow + 1, currentCol, newColor, oldColor);
        fillFlood(images, currentRow - 1, currentCol, newColor, oldColor);
        fillFlood(images, currentRow, currentCol + 1, newColor, oldColor);
        fillFlood(images, currentRow, currentCol - 1, newColor, oldColor);

    }

    public static void main(String[] args) {

        int images[][] = { { 0, 1, 1, 0 },
                { 0, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 0, 1, 0, 1 } };
        int sr = 2;
        int sc = 2;
        int newColor = 7;
        // findConnected(images, sr, sc, newColor);/

        fillFlood(images, sr, sc, newColor, images[sr][sc]);
        printImage(images);
    }

}
