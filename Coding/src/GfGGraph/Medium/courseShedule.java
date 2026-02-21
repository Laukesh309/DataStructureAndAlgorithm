package GfGGraph.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class courseShedule {

    public static void createGraph(int prerequisites[][], int v, ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int source = prerequisites[i][0];
            int dest = prerequisites[i][1];
            graph.get(source).add(dest);
        }
    }

    public static boolean courseSchedule(ArrayList<ArrayList<Integer>> graph, int v, int edges[][]) {
        int inOrder[] = new int[v];
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            int dest = edges[i][1];
            inOrder[dest]++;
        }
        for (int i = 0; i < v; i++) {
            if (inOrder[i] == 0) {
                que.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!que.isEmpty()) {
            int curVertex = que.poll();
            result.add(curVertex);
            for (int i = 0; i < graph.get(curVertex).size(); i++) {
                int neighbour = graph.get(curVertex).get(i);
                inOrder[neighbour]--;
                if (inOrder[neighbour] == 0) {
                    que.add(neighbour);
                }
            }
        }
        return result.size() == v;

    }

    public static void main(String[] args) {
        int n = 4;
        int[][] prerequisites = { { 2, 0 }, { 2, 1 }, { 3, 2 } };
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        createGraph(prerequisites, n, graph);
        courseSchedule(graph, n, prerequisites);
    }

}
