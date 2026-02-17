package BackTrackingGFG.Medium;

import java.util.ArrayList;

public class pathGreaterThanK {

    static class Edge {
        int dest;
        int cast;

        Edge(int dest, int cast) {
            this.dest = dest;
            this.cast = cast;
        }
    }

    public static boolean checkPath(ArrayList<ArrayList<Edge>> edge, boolean visited[], int currentVertex,
            int K) {

        if (K <= 0) {
            return true;
        }

        for (int i = 0; i < edge.get(currentVertex).size(); i++) {

            int neighbour = edge.get(currentVertex).get(i).dest;
            int cast = edge.get(currentVertex).get(i).cast;
            if (visited[neighbour] == true) {
                continue;
            }
            if (cast >= K) {
                return true;
            }
            visited[neighbour] = true;
            if (checkPath(edge, visited, neighbour, K - cast)) {
                return true;
            }
            visited[neighbour] = false;
        }

        return false;

    }

    public static void main(String[] args) {
        int A[] = { 0, 1, 5, 1, 2, 1, 2, 3, 1 };
        int V = 4;
        int E = 3;
        ArrayList<ArrayList<Edge>> edge = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            edge.add(new ArrayList<>());
        }
        for (int i = 0; i < 3 * E; i += 3) {
            int source = A[i];
            int dest = A[i + 1];
            int cast = A[i + 2];
            edge.get(source).add(new Edge(dest, cast));
            edge.get(dest).add(new Edge(source, cast));

        }

        System.out.println(edge);
        boolean visited[] = new boolean[V];
        int K = 8;
        visited[0] = true;
        System.out.println(checkPath(edge, visited, 0, K));

    }

}
