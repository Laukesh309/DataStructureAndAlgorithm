package GraphCode;

import java.util.ArrayList;

public class buildGraph1 {

    static class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void main(String[] args) {
        int vertex = 5;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));
        graph[4].add(new Edge(4, 2));

        // print 2nd neighbour

        for (int i = 0; i < graph[3].size(); i++) {
            System.out.println(graph[3].get(i).dest);
        }

    }

}
