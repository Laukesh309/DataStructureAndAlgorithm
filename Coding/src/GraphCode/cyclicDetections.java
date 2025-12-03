package GraphCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cyclicDetections {

    static class Edge {
        int source;
        int dest;

        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    static class Pair {
        int source;
        int parent;

        Pair(int source, int parent) {
            this.source = source;
            this.parent = parent;
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
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 5));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 6));
        graph[5].add(new Edge(5, 4));

        graph[6].add(new Edge(6, 5));

    }

    public static void dfsTraversal(ArrayList<Edge> graph[], boolean visited[], int sourceVertex) {
        if (visited[sourceVertex]) {
            return;
        }
        visited[sourceVertex] = true;
        System.out.print(sourceVertex + " -> ");
        for (int i = 0; i < graph[sourceVertex].size(); i++) {
            Edge currentEdge = graph[sourceVertex].get(i);
            dfsTraversal(graph, visited, currentEdge.dest);
        }
        return;
    }

    public static void bfsTraversal(ArrayList<Edge> graph[], boolean visited[], int sourceVertex) {
        Queue<Integer> que = new LinkedList<>();
        que.add(sourceVertex);
        while (!que.isEmpty()) {
            int currentValue = que.remove();
            if (!visited[currentValue]) {
                visited[currentValue] = true;
                System.out.print(currentValue + " -> ");
                for (int i = 0; i < graph[currentValue].size(); i++) {
                    Edge edge = graph[currentValue].get(i);
                    que.add(edge.dest);
                }
            }
        }

    }

    public static boolean cycleDetection(ArrayList<Edge> graph[], boolean visited[], int source, int parent) {

        visited[source] = true;
        for (int i = 0; i < graph[source].size(); i++) {
            Edge edge = graph[source].get(i);
            System.out.print(edge.dest + " ");
            if (visited[edge.dest]) {
                if (edge.dest != parent) {
                    return true;
                }
            }
            if (!visited[edge.dest]) {
                if (cycleDetection(graph, visited, edge.dest, source)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean cycleDetectionBfs(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];
        Queue<Pair> que = new LinkedList<>();
        int source = 0;
        que.add(new Pair(source, -1));
        visited[source] = true;
        while (!que.isEmpty()) {
            Pair currentPair = que.remove();
            int currentIndex = currentPair.source;
            int parent = currentPair.parent;
            for (int i = 0; i < graph[currentIndex].size(); i++) {
                Edge edge = graph[currentIndex].get(i);
                int dest = edge.dest;
                if (visited[dest]) {
                    if (dest != parent) {
                        System.out.println(dest + " " + parent);
                        return true;
                    }

                } else {
                    visited[dest] = true;
                    que.add(new Pair(dest, currentIndex));
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int totalVertex = 7;

        ArrayList<Edge> graph[] = new ArrayList[totalVertex];
        createGraph(graph);
        boolean visited[] = new boolean[totalVertex];
        // dfsTraversal(graph, visited, 0);
        // bfsTraversal(graph, visited, 0);
        // System.out.println(cycleDetection(graph, visited, 0, -1));
        System.out.println(cycleDetectionBfs(graph));

    }

}
