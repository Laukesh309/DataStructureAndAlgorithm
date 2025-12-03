package GraphRevision;

public class floodFills {

    public static void fillColor(int[][] image, int sr, int sc, int currentColor, int color, boolean visited[][]) {
        if (image[sr][sc] != currentColor || visited[sr][sc]) {
            return;
        }
        image[sr][sc] = color;
        visited[sr][sc] = true;
        // move right
        if (sc + 1 < image[sr].length && !visited[sr][sc + 1]) {
            fillColor(image, sr, sc + 1, currentColor, color, visited);
        }
        // move left
        if (sc - 1 >= 0 && !visited[sr][sc - 1]) {
            fillColor(image, sr, sc - 1, currentColor, color, visited);
        }
        // move top
        if (sr - 1 >= 0 && !visited[sr - 1][sc]) {
            fillColor(image, sr - 1, sc, currentColor, color, visited);
        }
        // move down
        if (sr + 1 < image.length && !visited[sr + 1][sc]) {
            fillColor(image, sr + 1, sc, currentColor, color, visited);
        }
    }

    public static void printArray(int[][] image) {
        for (int[] row : image) {
            for (int item : row) {
                System.out.print(item + " ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1;
        int sc = 1;
        int color = 2;
        int currentColor = image[sr][sc];
        boolean visited[][] = new boolean[image.length][image[0].length];
        fillColor(image, sr, sc, currentColor, color, visited);
        printArray(image);

    }

}
