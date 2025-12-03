package GraphRevision;

import java.util.ArrayList;

public class detectCycleDFS1 {

    public static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int source, ArrayList<Integer> path,
            boolean visited[]) {
        path.add(source);
        visited[source] = true;
        for (int i = 0; i < adj.get(source).size(); i++) {
            int dest = adj.get(source).get(i);
            if (!visited[dest] && detectCycle(adj, dest, path, visited)) {
                return true;
            }
            if (visited[dest] && path.contains(dest)) {

                return true;
            }
        }
        path.remove(path.size() - 1);
        return false;

    }

    public static boolean detectCycleUtil(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(adj, i, new ArrayList<>(), visited)) {
                    return true;
                }
            }

        }
        return false;

    }

    public static void main(String[] args) {
        int V = 4, edges[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            adj.get(source).add(dest);
        }
        System.out.println(detectCycleUtil(adj, V));
    }

}
