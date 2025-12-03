package GraphStriver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class cycleDetection {

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
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 5));

        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 6));

        graph[5].add(new Edge(5, 2));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 4));
        graph[6].add(new Edge(6, 5));
    }

    public static boolean detectCycle(ArrayList<Edge> graph[]) {
        Queue<Pair> que = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        que.add(new Pair(0, -1));
        visited[0] = true;
        while (!que.isEmpty()) {
            Pair curPair = que.remove();
            int source = curPair.source;
            int parent = curPair.parent;
            for (int i = 0; i < graph[source].size(); i++) {
                Edge edge = graph[source].get(i);
                if (!visited[edge.dest]) {
                    visited[edge.dest] = true;
                    que.add(new Pair(edge.dest, source));
                } else {
                    if (parent != edge.dest) {
                        System.out.println(edge.dest);
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int vertex = 7;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);
        System.out.println(detectCycle(graph));
    }

}
