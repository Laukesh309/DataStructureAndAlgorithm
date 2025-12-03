package GraphRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {

    public static boolean findBartite(ArrayList<ArrayList<Integer>> adj, int visited[]) {
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        visited[0] = 1;
        while (!que.isEmpty()) {
            int dest = que.poll();
            for (int i = 0; i < adj.get(dest).size(); i++) {
                int curDest = adj.get(dest).get(i);
                if (visited[curDest] == 0) {
                    que.add(curDest);
                    visited[curDest] = visited[dest] == 1 ? 2 : 1;
                } else {
                    if (que.contains(curDest)) {
                        if (visited[curDest] == visited[dest]) {
                            return false;
                        }

                    }

                }
            }

        }

        return true;

    }

    public static void main(String[] args) {
        int V = 4, edges[][] = {
                { 0, 3 },
                { 1, 2 },
                { 3, 2 },
                { 0, 2 }
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        int visited[] = new int[V];
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int sourceVertex = edges[i][0];
            int destVertex = edges[i][1];
            adj.get(sourceVertex).add(destVertex);
            adj.get(destVertex).add(sourceVertex);
        }
        System.out.println(findBartite(adj, visited));

    }

}
