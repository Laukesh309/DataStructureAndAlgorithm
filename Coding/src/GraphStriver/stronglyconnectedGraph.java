package GraphStriver;

import java.util.ArrayList;
import java.util.Stack;

public class stronglyconnectedGraph {

    public static void dfc(ArrayList<ArrayList<Integer>> adj, boolean visited[], int source, Stack<Integer> node) {
        visited[source] = true;
        for (int i = 0; i < adj.get(source).size(); i++) {
            int dest = adj.get(source).get(i);
            if (!visited[dest]) {
                dfc(adj, visited, dest, node);
            }
        }
        node.push(source);

    }

    public static void dfc2(ArrayList<ArrayList<Integer>> adj, boolean visited[], int source) {
        visited[source] = true;
        for (int i = 0; i < adj.get(source).size(); i++) {
            int dest = adj.get(source).get(i);
            if (!visited[dest]) {
                dfc2(adj, visited, dest);
            }
        }

    }

    public static void findConnectedComponent(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<ArrayList<Integer>> newAdj = new ArrayList<>();
        Stack<Integer> node = new Stack<>();
        for (int i = 0; i < adj.size(); i++) {
            newAdj.add(new ArrayList<>());
        }
        boolean visited[] = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfc(adj, visited, i, node);
            }
        }
        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> tempArray = adj.get(i);
            visited[i] = false;
            for (int j = 0; j < tempArray.size(); j++) {
                int dest = tempArray.get(j);
                newAdj.get(dest).add(i);
            }
        }
        int count = 0;
        while (!node.empty()) {
            int currentElement = node.pop();
            if (!visited[currentElement]) {
                count++;
                dfc2(newAdj, visited, currentElement);
            }

        }
        System.out.println(count);

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(2).add(1);
        adj.get(3).add(4);
        findConnectedComponent(adj);

    }

}
