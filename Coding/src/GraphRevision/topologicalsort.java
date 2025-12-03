package GraphRevision;

import java.util.ArrayList;
import java.util.Stack;

public class topologicalsort {

    public static void perFormDfs(ArrayList<ArrayList<Integer>> adj, int source, Stack<Integer> st) {
        for (int i = 0; i < adj.get(source).size(); i++) {
            int dest = adj.get(source).get(i);
            if (!st.contains(dest)) {
                perFormDfs(adj, dest, st);
            }

        }
        st.push(source);
    }

    public static void findTopological(ArrayList<ArrayList<Integer>> adj, int V) {
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!result.contains(i)) {
                perFormDfs(adj, i, result);
            }
        }
        ArrayList<Integer> finalResult = new ArrayList<>();
        while (!result.isEmpty()) {

            finalResult.add(result.pop());
        }
        System.out.println(finalResult);

    }

    public static void main(String[] args) {
        int V = 4, edges[][] = { { 3, 0 }, { 1, 0 }, { 2, 0 } };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            adj.get(source).add(dest);
        }
        System.out.println(adj);
        findTopological(adj, V);
    }

}
