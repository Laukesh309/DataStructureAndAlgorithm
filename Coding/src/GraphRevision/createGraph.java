package GraphRevision;

import java.util.ArrayList;

public class createGraph {

    public static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void printNeighbour(ArrayList<Edge> graph[], int neighbour) {
        ArrayList<Edge> edge = graph[neighbour];
        for (int i = 0; i < edge.size(); i++) {
            Edge current = edge.get(i);
            System.out.print(current.destination + "  ");
        }
    }

    public static void main(String[] args) {
        int totalVertex = 5;
        ArrayList<Edge> graph[] = new ArrayList[totalVertex];
        for (int i = 0; i < totalVertex; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 4, 2));
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        graph[4].add(new Edge(4, 2, 1));
        printNeighbour(graph, 1);
    }
}
