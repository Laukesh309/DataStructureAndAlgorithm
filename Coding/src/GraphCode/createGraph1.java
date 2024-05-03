package GraphCode;

import java.util.ArrayList;

public class createGraph1 {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void printNeighbour(ArrayList<Edge> graph[], int vertex) {

        if (vertex >= graph.length) {
            System.out.println("vertext does not exits");
        }
        for (int i = 0; i < graph[vertex].size(); i++) {
            System.out.print(graph[vertex].get(i).dest + " ");
        }
        return;

    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList();
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
    }

    public static void main(String[] args) {
        int totalVertex = 5;
        ArrayList<Edge> graph[] = new ArrayList[totalVertex];
        createGraph(graph);
        printNeighbour(graph, 4);
    }

}
