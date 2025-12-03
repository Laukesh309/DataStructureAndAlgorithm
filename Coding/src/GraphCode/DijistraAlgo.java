package GraphCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DijistraAlgo {

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

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

    }

    public static void printArray(int result[]) {
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static void findShortestPath(ArrayList<Edge> graph[], int source, int result[]) {
        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        result[source] = 0;
        while (!que.isEmpty()) {
            int currIndex = que.remove();
            for (int i = 0; i < graph[currIndex].size(); i++) {
                Edge edge = graph[currIndex].get(i);
                int currPathValue = result[currIndex] + edge.weight;
                if (currPathValue < result[edge.dest]) {
                    que.add(edge.dest);
                    result[edge.dest] = currPathValue;
                }
            }
        }
        printArray(result);
    }

    public static void main(String[] args) {

        int vertex = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);
        int result[] = new int[vertex];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        findShortestPath(graph, 0, result);

    }

}
