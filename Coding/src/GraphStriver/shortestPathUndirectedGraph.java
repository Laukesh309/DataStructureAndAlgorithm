package GraphStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class shortestPathUndirectedGraph {

    public static void createGraph(List<List<Integer>> graph, int edge[][], int V) {
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
    }

    public static void printArray(int result[]) {
        for (int i : result) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    public static void findAllDistance(List<List<Integer>> graph, int source) {

        int result[] = new int[graph.size()];
        Arrays.fill(result, Integer.MAX_VALUE);
        System.out.println(graph.size());
        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        result[source] = 0;
        while (!que.isEmpty()) {
            int currentNode = que.remove();
            for (int i = 0; i < graph.get(currentNode).size(); i++) {
                int dest = graph.get(currentNode).get(i);
                if (result[dest] == Integer.MAX_VALUE) {
                    que.add(dest);
                    result[dest] = result[currentNode] + 1;
                }
            }

        }

    }

    public static void main(String[] args) {
        int V = 9;
        int edge[][] = { { 1, 3 }, { 0, 2 }, { 1, 6 }, { 0, 4 }, { 3, 5 }, { 4, 6 }, { 2, 5 }, { 7, 8 }, { 6, 8 },
                { 7, 6 } };
        List<List<Integer>> graph = new ArrayList<>(V);
        createGraph(graph, edge, V);
        findAllDistance(graph, 0);

    }

}
