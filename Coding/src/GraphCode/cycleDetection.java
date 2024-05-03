package GraphCode;

import java.util.ArrayList;

public class cycleDetection {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean cyclePresent(ArrayList<Edge> graph[], int currentVertex, boolean visited[], int parentIndex) {
        visited[currentVertex] = true;
        for (int i = 0; i < graph[currentVertex].size(); i++) {
            Edge edg = graph[currentVertex].get(i);
            if (!visited[edg.dest]) {
                if (cyclePresent(graph, edg.dest, visited, currentVertex)) {
                    return true;
                }
            }
            if (visited[edg.dest] && edg.dest != parentIndex) {
                return true;
            }
        }

        return false;

    }

    public static boolean isCycle(ArrayList<Edge> graph[]) {
        boolean visited[] = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (cyclePresent(graph, i, visited, -1)) {
                    return true;
                }
            }
        }

        return false;

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
        ArrayList<Edge> graph[] = new ArrayList[totalVertex];
        for (int i = 0; i < totalVertex; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);

        System.out.println(isCycle(graph));

    }

}
