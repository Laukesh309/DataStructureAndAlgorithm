package GraphRevision;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class primsAlgo {
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
        int dest;
        int path;

        Pair(int dest, int path) {
            this.dest = dest;
            this.path = path;
        }

        @Override

        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 2, 50));
        graph[3].add(new Edge(3, 1, 40));

    }

    public static int findMST(ArrayList<Edge> graph[], int source) {
        boolean visited[] = new boolean[graph.length];
        int result = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(source, 0));
        while (!pq.isEmpty()) {
            Pair pair = pq.remove();
            if (!visited[pair.dest]) {
                visited[pair.dest] = true;
                result = result + pair.path;
                for (int i = 0; i < graph[pair.dest].size(); i++) {
                    Edge edge = graph[pair.dest].get(i);
                    pq.add(new Pair(edge.dest, edge.weight));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int vertex = 4;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);
        System.out.println(findMST(graph, 0));

    }
}
