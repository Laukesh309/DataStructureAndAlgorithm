package GraphStriver;

public class FloydWarshal {

    public static void printArray(int dist[][]) {
        for (int[] is : dist) {
            for (int item : is) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void findMinDistance(int dist[][]) {
        int vertex = dist.length;
        int INF = 100000000;
        for (int via = 0; via < vertex; via++) {

            for (int row = 0; row < vertex; row++) {
                for (int column = 0; column < vertex; column++) {
                    if (dist[row][via] != INF && dist[via][column] != INF) {
                        dist[row][column] = Math.min(dist[row][via] + dist[via][column], dist[row][column]);
                    }

                }
            }
        }
        printArray(dist);
    }

    public static void main(String[] args) {
        int dist[][] = { { 0, 4, Integer.MAX_VALUE, 5, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, 0, 1, Integer.MAX_VALUE, 6 }, { 2, Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 0, 2 }, { 1, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 0 } };
        findMinDistance(dist);

    }

}
