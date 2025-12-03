package GraphStriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class topologicalSort {

    public static void createGraph(int[][] edge, int V, List<List<Integer>> graph) {
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            int source = edge[i][0];
            int dest = edge[i][1];
            graph.get(source).add(dest);
        }
    }

    public static void perFormDfs(List<List<Integer>> graph, int source, Stack<Integer> result, boolean visited[]) {
        visited[source] = true;
        for (int i = 0; i < graph.get(source).size(); i++) {
            int dest = graph.get(source).get(i);
            if (!visited[dest]) {
                perFormDfs(graph, source, result, visited);
            }
        }
        result.add(source);

    }

    public static void findTopologicalSort(List<List<Integer>> graph, int V) {
        boolean visited[] = new boolean[V];
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                perFormDfs(graph, i, result, visited);
            }
        }
        ArrayList<Integer> finalResult = new ArrayList<>();
        while (!result.isEmpty()) {
            finalResult.add(result.pop());
        }
        System.out.println(finalResult);
    }

    public static void printIndegree(int indegree[]) {
        for (int i : indegree) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void findTopoLogicalSort(List<List<Integer>> graph, int V) {
        int indegree[] = new int[V];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int dest = graph.get(i).get(j);
                indegree[dest]++;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                que.add(i);
            }
        }
        while (!que.isEmpty()) {
            int currentIndex = que.remove();
            result.add(currentIndex);
            for (int i = 0; i < graph.get(currentIndex).size(); i++) {
                int dest = graph.get(currentIndex).get(i);
                indegree[dest]--;
                if (indegree[dest] == 0) {
                    que.add(dest);
                }
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        int V = 4;
        int E = 3;
        int edges[][] = { { 3, 0 }, { 1, 0 }, { 2, 0 } };
        List<List<Integer>> graph = new ArrayList<List<Integer>>(V);
        createGraph(edges, V, graph);
        // findTopologicalSort(graph, V);
        findTopoLogicalSort(graph, V);

    }
}
