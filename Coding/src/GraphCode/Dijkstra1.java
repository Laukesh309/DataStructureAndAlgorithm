package GraphCode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra1 {

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

    static class SrcWeightPair implements Comparable<SrcWeightPair> {
        int src;
        int weight;

        SrcWeightPair(int src, int weight) {
            this.src = src;
            this.weight = weight;
        }

        @Override
        public int compareTo(SrcWeightPair s2) {
            return this.weight - s2.weight;
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

    public static void dijikstraAlgo(ArrayList<Edge> graph[], int src) {
        boolean visited[] = new boolean[graph.length];
        int distance[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<SrcWeightPair> pq = new PriorityQueue<>();
        pq.add(new SrcWeightPair(src, 0));
        while (!pq.isEmpty()) {
            SrcWeightPair swp = pq.remove();
            if (!visited[swp.src]) {
                visited[swp.src] = true;
                for (int i = 0; i < graph[swp.src].size(); i++) {
                    Edge edge = graph[swp.src].get(i);
                    int src1 = edge.src;
                    int dest = edge.dest;
                    int weight = edge.weight;
                    if (distance[src1] + weight < distance[dest]) {
                        distance[dest] = distance[src1] + weight;
                        pq.add(new SrcWeightPair(dest, distance[src1] + weight));
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
        dijikstraAlgo(graph, 0);

    }

}
