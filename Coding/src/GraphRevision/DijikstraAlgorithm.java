package GraphRevision;

import java.util.ArrayList;

import String.findShortestPath;

public class DijikstraAlgorithm {
    static class Edge {
        int source;
        int dest;
        int weight;

        Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 5, 5));
        graph[4].add(new Edge(4, 3, 2));

    }

    public static void findShartestPath(ArrayList<Edge> graph[], int currentSource, int currentPathValue, int dp[]) {
        dp[currentSource] = Math.min(currentPathValue, dp[currentSource]);
        for (int i = 0; i < graph[currentSource].size(); i++) {
            Edge currEdge = graph[currentSource].get(i);
            findShartestPath(graph, currEdge.dest, currentPathValue + currEdge.weight, dp);

        }
    }

    public static void printDp(int dp[]) {
        for (int i : dp) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int vertex = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);
        int dp[] = new int[vertex];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        findShartestPath(graph, 0, 0, dp);
        printDp(dp);

    }
}
