package GraphStriver;

public class enclaveArea {

    public static void perFormDfs(int graph[][], int visited[][], int row, int col) {
        visited[row][col] = 1;
        int dRow[] = { 0, 0, -1, 1 };
        int dCol[] = { 1, -1, 0, 0 };
        for (int i = 0; i < 4; i++) {
            int cRow = row + dRow[i];
            int cCol = col + dCol[i];
            if (cRow >= 0 && cCol >= 0 && cRow < graph.length && cCol < graph[0].length && graph[cRow][cCol] == 1
                    && visited[cRow][cCol] != 1) {
                perFormDfs(graph, visited, cRow, cCol);
            }
        }

    }

    public static int totalNoOfLand(int graph[][]) {
        int visited[][] = new int[graph.length][graph[0].length];
        int totalLand = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 1) {
                    totalLand++;
                }
            }
        }
        // execute for firstRow
        for (int col = 0; col < graph[0].length; col++) {
            if (visited[0][col] == 0 && graph[0][col] == 1) {
                perFormDfs(graph, visited, 0, col);

            }
            if (visited[graph.length - 1][col] == 0 && graph[graph.length - 1][col] == 1) {
                perFormDfs(graph, visited, graph.length - 1, col);
            }
        }
        for (int row = 1; row < graph.length - 1; row++) {
            if (visited[row][0] == 0 && graph[row][0] == 1) {
                perFormDfs(graph, visited, row, 0);

            }
            if (visited[row][graph[0].length - 1] == 0 && graph[row][graph[0].length - 1] == 1) {
                perFormDfs(graph, visited, row, graph[0].length - 1);
            }
        }
        int totalvisit = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (visited[i][j] == 1) {
                    totalvisit++;
                }
            }
        }
        return totalLand - totalvisit;
    }

    public static void main(String[] args) {
        int grid[][] = { { 0, 0, 0, 1 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 1 },
                { 0, 1, 1, 0 } };
        System.out.println(totalNoOfLand(grid));

    }

}
