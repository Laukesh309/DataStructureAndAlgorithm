package GraphCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Dijikstra {

    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
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

    static class Pair implements Comparable<Pair> {
        int node;
        int path;

        Pair(int node, int path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair n2) {
            return this.path - n2.path;
        }

    }

    public static void findPath(ArrayList<Edge> graph[], int src) {

        int distance[] = new int[graph.length];
        boolean visited[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair currentPair = pq.remove();
            if (!visited[currentPair.node]) {
                visited[currentPair.node] = true;
                for (int i = 0; i < graph[currentPair.node].size(); i++) {
                    Edge edge = graph[currentPair.node].get(i);

                    int src1 = edge.src;
                    int dest = edge.dest;
                    int weight = edge.weight;
                    if (currentPair.path + weight < distance[dest]) {
                        distance[dest] = currentPair.path + weight;
                        pq.add(new Pair(dest, currentPair.path + weight));
                    }

                }

            }
        }
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
    }

    public static void main(String[] args) {
        int totalVertex = 6;
        ArrayList<Edge> graph[] = new ArrayList[totalVertex];
        createGraph(graph);
        findPath(graph, 0);

    }

}
