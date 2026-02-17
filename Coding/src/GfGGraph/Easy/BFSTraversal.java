package GfGGraph.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFSTraversal {

    public static ArrayList<Integer> findBFS(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> pq = new LinkedList();
        boolean visited[] = new boolean[adj.size()];
        pq.add(0);
        visited[0] = true;
        result.add(0);
        while (!pq.isEmpty()) {
            int currentIndex = pq.poll();
            for (int i = 0; i < adj.get(currentIndex).size(); i++) {
                int neighbor = adj.get(currentIndex).get(i);
                if (visited[neighbor] == false) {
                    pq.add(neighbor);
                    visited[neighbor] = true;
                    result.add(neighbor);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int adj[][] = { { 1, 2, 4, 8 }, { 0, 5, 6, 9 }, { 0, 4 }, { 7, 8 }, { 0, 2 }, { 1, 8 }, { 1, 7, 9 }, { 3, 6 },
                { 0, 3, 5 }, { 1, 6 } };
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < adj.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < adj[i].length; j++) {
                temp.add(adj[i][j]);
            }
            graph.add(temp);
        }
        // System.out.println(graph);
        System.out.println(findBFS(graph));
    }

}
