package GraphRevision;

import java.util.ArrayList;
import java.util.Stack;

public class courseScheduleSecond {

    public static boolean findTopo(ArrayList<ArrayList<Integer>> adj, int source, boolean visited[],
            Stack<Integer> stack, ArrayList<Integer> path) {
        visited[source] = true;
        path.add(source);
        for (int i = 0; i < adj.get(source).size(); i++) {
            int dest = adj.get(source).get(i);
            if (path.contains(dest)) {
                return true;
            } else {
                if (!visited[dest] && findTopo(adj, dest, visited, stack, path)) {
                    return true;
                }
            }
        }
        path.remove(path.size() - 1);
        stack.push(source);
        return false;

    }

    public static ArrayList<Integer> findCycle(ArrayList<ArrayList<Integer>> adj, int v) {
        boolean visited[] = new boolean[v];
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                if (findTopo(adj, i, visited, result, new ArrayList<>())) {
                    return new ArrayList<>();
                }
            }

        }
        ArrayList<Integer> finalResult = new ArrayList<>();
        while (!result.isEmpty()) {
            finalResult.add(result.pop());

        }
        return finalResult;

    }

    public static void main(String[] args) {
        int numCourses = 4, prerequisites[][] = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int source = prerequisites[i][0];
            int dest = prerequisites[i][1];
            adj.get(dest).add(source);
        }

    }

}
