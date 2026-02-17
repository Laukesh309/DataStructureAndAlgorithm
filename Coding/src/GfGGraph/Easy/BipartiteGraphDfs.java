package GfGGraph.Easy;

import java.util.ArrayList;

import top150InterviewProblem.Array.intergerToRoman;

public class BipartiteGraphDfs {

    public static void createGraph(int edges[][], int V, ArrayList<ArrayList<Integer>> graph) {

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            graph.get(source).add(dest);
            graph.get(dest).add(source);
        }

    }

    public static boolean findBipartite(ArrayList<ArrayList<Integer>> graph, int currentIndex, int color[]) {

        for (int i = 0; i < graph.get(currentIndex).size(); i++) {
            int neighbour = graph.get(currentIndex).get(i);
            if (color[neighbour] == color[currentIndex]) {
                return false;
            }
            if (color[neighbour] == -1) {
                color[neighbour] = color[currentIndex] == 0 ? 1 : 0;
                if (!findBipartite(graph, neighbour, color)) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean checkBipartite(ArrayList<ArrayList<Integer>> graph, int V) {
        int color[] = new int[V];
        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }
        for (int i = 0; i < V; i++) {
            if (color[i] != 1) {
                color[i] = 0;
                if (!findBipartite(graph, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 4;
        int edges[][] = { { 0, 3 }, { 1, 2 }, { 3, 2 }, { 0, 2 } };
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        createGraph(edges, V, graph);
        System.out.println(checkBipartite(graph, V));

    }

}
