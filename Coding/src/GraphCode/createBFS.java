package GraphCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class createBFS {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean haspath(ArrayList<Edge> graph[], int src, int dest, boolean visited[]) {
        if (src == dest) {
            return true;
        }
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge edge = graph[src].get(i);
            if (!visited[edge.dest] && haspath(graph, edge.dest, dest, visited)) {
                return true;
            }
        }

        return false;
    }

    public static void DFSTraversal(ArrayList<Edge> graph[], int initialVertex, boolean visited[]) {

        // first Ways
        // if (!visited[initialVertex]) {
        // visited[initialVertex] = true;
        // System.out.print(initialVertex + " ");
        // for (int i = 0; i < graph[initialVertex].size(); i++) {
        // DFSTraversal(graph, graph[initialVertex].get(i).dest, visited);
        // }
        // }

        // second ways

        visited[initialVertex] = true;
        System.out.print(initialVertex + " ");

        for (int i = 0; i < graph[initialVertex].size(); i++) {
            Edge graphEdge = graph[initialVertex].get(i);
            if (!visited[graphEdge.dest]) {
                DFSTraversal(graph, graphEdge.dest, visited);
            }
        }

    }

    public static void BFSTraversal(ArrayList<Edge> graph[], int initialVertex) {
        boolean visited[] = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList();
        queue.add(initialVertex);
        while (!queue.isEmpty()) {
            int currentVertex = queue.remove();
            if (!visited[currentVertex]) {
                visited[currentVertex] = true;
                System.out.print(currentVertex + " ");
                for (int i = 0; i < graph[currentVertex].size(); i++) {
                    Edge neigbourEdge = graph[currentVertex].get(i);
                    queue.add(neigbourEdge.dest);
                }
            }

        }
        System.out.println();
    }

    public static void createGraph(ArrayList<Edge> graph[]) {

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
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
        boolean visited[] = new boolean[totalVertex];
        ArrayList<Edge> graph[] = new ArrayList[totalVertex];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList();
        }
        createGraph(graph);
        // BFSTraversal(graph, 3);
        // DFSTraversal(graph, 0, visited);
        System.out.println(haspath(graph, 0, 6, visited));
    }

}
