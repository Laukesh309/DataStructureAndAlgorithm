package GraphCode;

public class cityWithSmallestNeobhour {

    public static void printMatrix(int matrix[][]) {
        for (int[] row : matrix) {
            for (int[] column : matrix) {
                System.out.print(column + " ");
            }
            System.out.println();

        }
    }

    public static int findMinDistance(int edges[][], int n, int m, int thresholdValue) {
        int matrix[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < edges.length; i++) {
            int row = edges[i][0];
            int column = edges[i][1];
            int weight = edges[i][2];
            matrix[row][column] = weight;
            matrix[column][row] = weight;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
        printMatrix(matrix);
        int min = Integer.MAX_VALUE;
        int count[] = new int[n];
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= thresholdValue) {
                    count[i] = count[i] + 1;
                }
            }
            if (count[i] <= min) {
                min = count[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        int n = 4, m = 4;
        int edges[][] = { { 0, 1, 3 },
                { 1, 2, 1 },
                { 1, 3, 4 },
                { 2, 3, 1 } };
        int distanceThreshold = 4;
        findMinDistance(edges, n, m, distanceThreshold);
    }
}
