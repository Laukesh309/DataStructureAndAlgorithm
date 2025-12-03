package GraphRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class shartestDistance {

    public static void findShortestPath(ArrayList<ArrayList<Integer>> adj, int source) {
        Queue<Integer> que = new LinkedList<>();
        boolean visited[] = new boolean[adj.size()];
        que.add(source);
        visited[source] = true;
        int result[] = new int[adj.size()];
        result[source] = 0;
        while (!que.isEmpty()) {
            int curSource = que.poll();
            int curDistance = result[curSource];
            for (int i = 0; i < adj.get(curSource).size(); i++) {
                int dest = adj.get(curSource).get(i);
                if (!visited[dest]) {
                    que.add(dest);
                    visited[dest] = true;
                    result[dest] = curDistance + 1;
                }
            }
        }
        System.out.println("result");

    }

    public static void findShortestPathDfs(ArrayList<ArrayList<Integer>> adj, int source, int curDest, int result[]) {
        for (int i = 0; i < adj.get(source).size(); i++) {
            int dest = adj.get(source).get(i);
            if (curDest + 1 < result[dest]) {
                result[dest] = curDest + 1;
                findShortestPathDfs(adj, dest, result[dest], result);
            }
        }

    }

    public static void main(String[] args) {
        int graph[][] = { { 1, 3 }, { 0, 2 }, { 1, 6 }, { 0, 4 }, { 3, 5 }, { 4, 6 }, { 2, 5 }, { 7, 8 }, { 6, 8 },
                { 7, 6 } };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(graph.length);
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            adj.get(i).add(graph[i][0]);
            adj.get(i).add(graph[i][1]);
            adj.get((graph[i][0])).add(i);
            adj.get((graph[i][1])).add(i);

        }
        // findShortestPath(adj, 0);
        int result[] = new int[graph.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        result[0] = 0;
        findShortestPathDfs(adj, 0, 0, result);
        for (int i : result) {
            System.out.println(i);
        }

    }

}
