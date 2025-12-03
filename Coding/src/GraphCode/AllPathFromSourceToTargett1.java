package GraphCode;

import java.util.ArrayList;

public class AllPathFromSourceToTargett1 {

    static class Edge {
        int source;
        int dest;

        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 0));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void printAllPath(ArrayList<Edge> graph[], ArrayList<Integer> result, int source, int destination) {

        if (source == destination) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < graph[source].size(); i++) {
            Edge edge = graph[source].get(i);
            result.add(edge.dest);
            printAllPath(graph, result, edge.dest, destination);
            result.remove(result.size() - 1);
        }

    }

    public static void main(String[] args) {
        int vertex = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        ArrayList<Integer> result = new ArrayList<>();
        createGraph(graph);
        int source = 5;
        int dest = 1;
        result.add(source);
        printAllPath(graph, result, source, dest);
        result.remove(result.size() - 1);

    }

}
