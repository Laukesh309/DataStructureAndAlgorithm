package GraphCode;

import java.util.ArrayList;

public class cycleDetectionDirected {

    static class Edge {
        int source;
        int destination;

        Edge(int source, int dest) {
            this.source = source;
            this.destination = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));

        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
    }

    public static void printArray(boolean visited[]) {
        for (boolean b : visited) {
            System.out.print(b + " ");
        }
        System.out.println();
    }

    public static boolean detectCycle(ArrayList<Edge> graph[], int currIndex, boolean visited[]) {
        if (visited[currIndex] == true) {
            printArray(visited);
            return true;
        }
        visited[currIndex] = true;
        for (int i = 0; i < graph[currIndex].size(); i++) {
            Edge currEdge = graph[currIndex].get(i);
            if (detectCycle(graph, currEdge.destination, visited)) {
                return true;
            }
        }
        visited[currIndex] = false;
        return false;

    }

    public static void main(String[] args) {
        int vertex = 4;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);
        boolean visited[] = new boolean[vertex];
        System.out.println(detectCycle(graph, 0, visited));

    }

}
