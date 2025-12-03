package GraphRevision;

import java.util.ArrayList;

public class courseSchedule {
    public static boolean findCycleDfs(ArrayList<ArrayList<Integer>> adj, int source, boolean visited[],
            ArrayList<Integer> path) {
        path.add(source);
        visited[source] = true;
        for (int i = 0; i < adj.get(source).size(); i++) {
            int dest = adj.get(source).get(i);
            if (path.contains(dest)) {
                return true;
            } else {
                if (findCycleDfs(adj, dest, visited, path)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean findCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (findCycleDfs(adj, i, visited, new ArrayList<>())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int source = prerequisites[i][0];
            int dest = prerequisites[i][1];
            adj.get(source).add(dest);
        }
        System.out.println(findCycle(adj, numCourses));
    }

}
