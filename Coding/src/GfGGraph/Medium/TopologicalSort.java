package GfGGraph.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import top150InterviewProblem.Array.intergerToRoman;

public class TopologicalSort {

    public static void createGraph(int edges[][], int V, ArrayList<ArrayList<Integer>> graph) {

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            graph.get(source).add(dest);
        }
    }

    public static void findTopo(ArrayList<ArrayList<Integer>> graph, int currentVertex, Stack<Integer> st) {

        if (st.contains(currentVertex)) {
            return;
        }
        for (int i = 0; i < graph.get(currentVertex).size(); i++) {
            int neighbour = graph.get(currentVertex).get(i);
            if (!st.contains(neighbour)) {
                findTopo(graph, neighbour, st);
            }
        }
        st.push(currentVertex);
    }

    public static void findTopoBFS(int edges[][], int V, ArrayList<ArrayList<Integer>> graph) {
        int inOrder[] = new int[V];
        for (int i = 0; i < edges.length; i++) {
            int dest = edges[i][1];
            inOrder[dest]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < V; i++) {
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
        System.out.println(result);
    }

    public static void main(String[] args) {
        int edges[][] = { { 3, 0 }, { 1, 0 }, { 2, 0 } };
        int V = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
        createGraph(edges, V, graph);
        Stack<Integer> result = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!result.contains(i)) {
                findTopo(graph, i, result);
            }
        }
        ArrayList<Integer> finalResult = new ArrayList<>();
        while (!result.isEmpty()) {
            finalResult.add(result.pop());
        }
        System.out.println(finalResult);
        findTopoBFS(edges, V, graph);
    }

}
