package GraphCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class buildGraph {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], boolean visited[], int current, int destination) {
        if (current == destination) {
            return true;
        }
        visited[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge ed = graph[current].get(i);
            if (!visited[ed.dest] && hasPath(graph, visited, ed.dest, destination)) {
                return true;
            }
        }
        return false;

    }

    public static void dfsTraversal(ArrayList<Edge> graph[], boolean visited[], int current) {
        System.out.print(current + " ");
        visited[current] = true;
        for (int i = 0; i < graph[current].size(); i++) {
            Edge edge = graph[current].get(i);
            if (!visited[edge.dest]) {
                dfsTraversal(graph, visited, edge.dest);
            }
        }
    }

    public static void bfsTraversal(ArrayList<Edge> graph[], int vertex) {
        Queue<Integer> que = new LinkedList<>();
        boolean arr[] = new boolean[vertex];
        que.add(0);
        while (!que.isEmpty()) {
            int source = que.remove();
            if (arr[source] == false) {
                ArrayList<Edge> currentSource = graph[source];
                for (int i = 0; i < currentSource.size(); i++) {
                    que.add(currentSource.get(i).dest);
                }
                System.out.print(source + " ");
                arr[source] = true;
            }
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 4));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 5));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));

    }

    public static void main(String[] args) {
        int totalVertex = 7;
        ArrayList<Edge> graph[] = new ArrayList[totalVertex];
        boolean visited[] = new boolean[totalVertex];
        createGraph(graph);
        // bfsTraversal(graph, totalVertex);
        // dfsTraversal(graph, visited, 0);
        System.out.println(hasPath(graph, visited, 0, 6));

    }

}
