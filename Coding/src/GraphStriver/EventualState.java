package GraphStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EventualState {

    public static void initilizeArrayList(List<List<Integer>> adj, int V) {
        for (int row = 0; row < V; row++) {
            adj.add(new ArrayList<>());
        }
    }

    public static void addEdge(List<List<Integer>> adj, int i, int j) {

        adj.get(i).add(j);

    }

    public static boolean perFormDfs(List<List<Integer>> adj, ArrayList<Integer> result, int source,
            boolean visited[]) {
        result.add(source);
        for (int i = 0; i < adj.get(source).size(); i++) {
            int dest = adj.get(source).get(i);
            if (!visited[dest]) {
                visited[dest] = true;
                if (perFormDfs(adj, result, dest, visited)) {
                    result.remove(result.size() - 1);
                    visited[dest] = false;
                    return true;
                }
                visited[dest] = false;
            } else {
                if (result.contains(dest)) {
                    result.remove(result.size() - 1);
                    return true;
                }
            }
        }
        result.remove(result.size() - 1);
        return false;

    }

    public static void findElement(List<List<Integer>> adj, ArrayList<Integer> result, int V) {
        boolean visited[] = new boolean[V];
        ArrayList<Integer> result2 = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!perFormDfs(adj, result, i, visited)) {
                result2.add(i);
            }
        }

        Collections.sort(result2);
        System.out.println(result2);
    }

    public static void main(String[] args) {
        int V = 7;
        List<List<Integer>> adj = new ArrayList<List<Integer>>(V);
        ArrayList<Integer> result = new ArrayList<>(V);
        initilizeArrayList(adj, V);
        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 5);
        addEdge(adj, 3, 0);
        addEdge(adj, 4, 5);

        findElement(adj, result, V);
    }

}
