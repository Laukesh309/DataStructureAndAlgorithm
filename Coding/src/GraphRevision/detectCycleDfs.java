package GraphRevision;

import java.util.ArrayList;

public class detectCycleDfs {

    public static boolean findDfsCycle(ArrayList<ArrayList<Integer>> edge, boolean visited[], int sourceVertex,
            int parentVertex) {
        visited[sourceVertex] = true;
        for (int i = 0; i < edge.get(sourceVertex).size(); i++) {
            int dest = edge.get(sourceVertex).get(i);
            if (visited[dest] && dest != parentVertex) {
                return true;
            }
            if (!visited[dest] && findDfsCycle(edge, visited, dest, sourceVertex)) {
                return true;
            }
        }
        return false;

    }

    public static boolean findCycle(ArrayList<ArrayList<Integer>> edge, int vertex) {
        boolean visited[] = new boolean[vertex];
        for (int i = 0; i < vertex; i++) {
            if (!visited[i] && findDfsCycle(edge, visited, i, -1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int vertex = 6;
        int edges[][] = { { 0, 1 },
                { 1, 2 },
                { 1, 3 },
                { 2, 4 }, { 3, 4 },
                { 4, 5 } };

        ArrayList<ArrayList<Integer>> edge = new ArrayList<>(vertex);
        for (int i = 0; i < vertex; i++) {
            edge.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            System.out.println(i);
            int source = edges[i][0];
            int dest = edges[i][1];
            edge.get(source).add(dest);
            edge.get(dest).add(source);
        }
        System.out.println("teting");
        System.out.println(findCycle(edge, vertex));

    }

}
