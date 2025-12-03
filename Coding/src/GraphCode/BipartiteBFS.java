package GraphCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteBFS {

    static class Edge {
        int source;
        int dest;

        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

    }

    public static boolean checkBipartiteGraph(ArrayList<Edge> graph[], int source) {
        boolean visited[] = new boolean[graph.length];
        int color[] = new int[graph.length];
        ArrayList<Integer> matrix1 = new ArrayList<>();
        ArrayList<Integer> matrix2 = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        matrix1.add(source);
        color[source] = 0;
        visited[source] = true;
        while (!que.isEmpty()) {
            int currentIndex = que.remove();
            int currentColor = color[currentIndex];
            for (int i = 0; i < graph[currentIndex].size(); i++) {
                Edge currEdge = graph[currentIndex].get(i);
                if (visited[currEdge.dest] && currentColor == color[currEdge.dest]) {
                    return false;
                }
                if (!visited[currEdge.dest]) {
                    visited[currEdge.dest] = true;
                    if (currentColor == 0) {
                        color[currEdge.dest] = 1;
                        matrix2.add(currEdge.dest);
                    } else {
                        color[currEdge.dest] = 0;
                        matrix1.add(currEdge.dest);
                    }
                    que.add(currEdge.dest);
                }
            }
        }
        System.out.println(matrix1);
        System.out.println(matrix2);
        return true;

    }

    public static void main(String[] args) {

        int vertex = 4;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);
        System.out.println(checkBipartiteGraph(graph, 0));
    }

}
