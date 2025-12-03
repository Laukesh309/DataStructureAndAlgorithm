package GraphRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnAlgorithm {

    public static void findTopological(ArrayList<ArrayList<Integer>> adj, int indegree[]) {
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!que.isEmpty()) {
            int source = que.poll();
            result.add(source);
            for (int i = 0; i < adj.get(source).size(); i++) {
                int dest = adj.get(source).get(i);
                indegree[dest]--;
                if (indegree[dest] == 0) {
                    que.add(dest);
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int V = 6;
        int edges[][] = { { 1, 3 }, { 2, 3 }, { 4, 1 }, { 4, 0 }, { 5, 0 }, { 5, 2 } };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int indegre[] = new int[V];
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            indegre[dest]++;
            adj.get(source).add(dest);
        }

        findTopological(adj, indegre);

    }

}
