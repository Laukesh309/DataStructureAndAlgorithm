package GraphRevision;

public class provinanceGroup {

    public static void findMaxProvinance(int[][] isConnected, int source, boolean visited[]) {
        visited[source] = true;
        for (int column = 0; column < isConnected[source].length; column++) {
            if (isConnected[source][column] == 1) {
                if (!visited[column]) {
                    findMaxProvinance(isConnected, column, visited);
                }
            }
        }
    }

    public static int totalResult(int[][] isConnected, int source, boolean visited[]) {

        int total = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                findMaxProvinance(isConnected, i, visited);
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[][] isConnected = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        int vertex = isConnected.length;
        boolean visited[] = new boolean[vertex];
        System.out.println(totalResult(isConnected, vertex, visited));

    }

}
