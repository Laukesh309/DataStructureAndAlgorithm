package GraphStriver;

import java.util.ArrayList;

public class cycleDetectionDirectedGraph {
    static class Edge {
        int source;
        int dest;

        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[], int edges[][], int v) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int dest = edges[i][1];
            graph[source].add(new Edge(source, dest));
        }

    }

    public static boolean isCycle(ArrayList<Edge> graph[], int source, ArrayList<Integer> path, boolean visited[]) {

        path.add(source);
        for (int i = 0; i < graph[source].size(); i++) {
            Edge edge = graph[source].get(i);
            int dest = edge.dest;
            if (!visited[dest]) {
                visited[dest] = true;
                if (isCycle(graph, dest, path, visited)) {

                    return true;
                }
            } else {
                if (path.contains(dest)) {
                    return true;
                }
            }
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static boolean cyclicUtil(ArrayList<Edge> graph[], int v) {
        boolean visited[] = new boolean[v];
        ArrayList<Integer> path = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (isCycle(graph, i, path, visited)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int V = 3;
        int edges[][] = { { 2, 1 },
                { 1, 2 },
                { 2, 0 } };
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph, edges, V);
        System.out.println(cyclicUtil(graph, V));

    }

}
