package GraphCode;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class primsAlgo {

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

    static class SrcDestPair implements Comparable<SrcDestPair> {
        int src;
        int weight;

        SrcDestPair(int src, int weight) {
            this.src = src;
            this.weight = weight;
        }

        @Override
        public int compareTo(SrcDestPair s2) {
            return this.weight - s2.weight;
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
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));

    }

    public static void calCulateMst(ArrayList<Edge> graph[], int src) {
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<SrcDestPair> pq = new PriorityQueue<>();
        int result = 0;
        pq.add(new SrcDestPair(0, 0));
        while (!pq.isEmpty()) {
            SrcDestPair current = pq.remove();
            if (!visited[current.src]) {
                visited[current.src] = true;
                result = result + current.weight;
                for (int i = 0; i < graph[current.src].size(); i++) {
                    Edge edg = graph[current.src].get(i);
                    pq.add(new SrcDestPair(edg.dest, edg.weight));

                }

            }

        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        int totalVertex = 4;
        ArrayList<Edge> graph[] = new ArrayList[totalVertex];
        createGraph(graph);
        calCulateMst(graph, 0);

    }

}
