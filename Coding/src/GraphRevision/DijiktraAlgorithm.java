package GraphRevision;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijiktraAlgorithm {

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

    static class Pair implements Comparable<Pair> {
        int currVertex;
        int weight;

        Pair(int currVertex, int weight) {
            this.currVertex = currVertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair n2) {
            return this.weight - n2.weight;
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

    public static void findShortedPath(ArrayList<Edge> graph[], int result[], int source) {
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, 0));
        while (!pq.isEmpty()) {
            Pair currenPair = pq.remove();
            int currVertex = currenPair.currVertex;
            int currPath = currenPair.weight;
            if (!visited[currVertex]) {
                result[currVertex] = currPath;
                visited[currVertex] = true;
                for (int i = 0; i < graph[currVertex].size(); i++) {
                    Edge edge = graph[currVertex].get(i);
                    int path = currPath + edge.weight;
                    if (!visited[edge.dest]) {
                        pq.add(new Pair(edge.dest, path));
                    }
                }
            }

        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static void main(String[] args) {
        int vertex = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);
        int result[] = new int[vertex];
        findShortedPath(graph, result, 0);
    }

}
