package GraphStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class bipartiteGraph {
    static class Edge {
        int source;
        int dest;

        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int matrix[][], int vertex) {
        for (int i = 0; i < vertex; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int row = 0; row < matrix.length; row++) {
            int source = matrix[row][0];
            int dest = matrix[row][1];
            graph[source].add(new Edge(source, dest));
            graph[dest].add(new Edge(dest, source));
        }

    }

    public static void printBFS(ArrayList<Edge> graph[], int source, int vertex) {
        Queue<Integer> que = new LinkedList<>();
        boolean visited[] = new boolean[vertex];
        que.add(source);
        visited[source] = true;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size > 0) {
                int currentElement = que.remove();
                System.out.print(currentElement + " ");
                for (int i = 0; i < graph[currentElement].size(); i++) {
                    int currDest = graph[currentElement].get(i).dest;
                    if (!visited[currDest]) {
                        visited[currDest] = true;
                        que.add(currDest);
                    }
                }
                size--;
            }
            System.out.println("-->");
        }

    }

    public static boolean checkBipartite(ArrayList<Edge> graph[]) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        color[0] = 0;
        while (!que.isEmpty()) {
            int curIndex = que.remove();
            for (int i = 0; i < graph[curIndex].size(); i++) {
                int dest = graph[curIndex].get(i).dest;
                if (color[dest] == -1) {
                    que.add(dest);
                    color[dest] = color[curIndex] == 0 ? 1 : 0;
                } else {
                    if (color[dest] == color[curIndex]) {
                        return false;
                    }
                }
            }

        }
        return true;
    }

    public static boolean dfsBipartite(ArrayList<Edge> graph[], int color[], int index) {

        for (int i = 0; i < graph[index].size(); i++) {
            int dest = graph[index].get(i).dest;
            if (color[dest] == -1) {
                color[dest] = color[index] == 0 ? 1 : 0;
                if (!dfsBipartite(graph, color, dest)) {
                    return false;
                }
            } else {
                if (color[dest] == color[index]) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int totalVertex = 5;
        ArrayList<Edge> graph[] = new ArrayList[totalVertex];
        int color[] = new int[totalVertex];
        Arrays.fill(color, -1);
        int matrix[][] = { { 0, 1 },
                { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 4, 0 } };
        createGraph(graph, matrix, totalVertex);
        // printBFS(graph, 0, totalVertex);
        System.out.println(checkBipartite(graph));
        color[0] = 0;
        System.out.println(dfsBipartite(graph, color, 0));

    }

}
