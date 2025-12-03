package GraphStriver;

public class noOfCity {

    public static void printArray(int result[]) {
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static void printGraph(int graph[][]) {
        for (int[] is : graph) {
            for (int item : is) {
                System.out.print(item + " ");

            }
            System.out.println();
        }
    }

    public static int findNoOFCity(int graph[][], int distanceThreshold, int n) {

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][via] != Integer.MAX_VALUE && graph[via][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][via] + graph[via][j], graph[i][j]);
                    }
                }
            }
        }
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] <= distanceThreshold) {
                    result[i] = result[i] + 1;
                }
            }
        }
        int minCount = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (result[i] < minCount) {
                minCount = result[i];
                index = i;
            } else if (minCount == result[i]) {
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 4;
        int graph[][] = new int[n][n];
        int distanceThreshold = 4;
        int edges[][] = { { 0, 1, 3 },
                { 1, 2, 1 },
                { 1, 3, 4 },
                { 2, 3, 1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < edges.length; i++) {
            int row = edges[i][0];
            int column = edges[i][1];
            int weight = edges[i][2];
            graph[row][column] = weight;
            graph[column][row] = weight;
        }
        findNoOFCity(graph, distanceThreshold, n);

    }

}
