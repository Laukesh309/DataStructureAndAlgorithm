package GraphCode;

import java.util.ArrayList;

public class BipartiteGraph {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {

            this.src = src;
            this.dest = dest;
        }
    }

    public static void createFirstGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

    }

    public static void createSecondGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

    }

    public static boolean checkBiratiteGraph(ArrayList<Edge> graph[], int currentVertex, int result[]) {

        for (int i = 0; i < graph[currentVertex].size(); i++) {
            Edge currentEdge = graph[currentVertex].get(i);
            if (result[currentEdge.dest] != -1 && result[currentVertex] == result[currentEdge.dest]) {
                return false;
            }
            if (result[currentEdge.dest] == -1) {
                result[currentEdge.dest] = result[currentVertex] == 0 ? 1 : 0;
                return checkBiratiteGraph(graph, currentEdge.dest, result);
            }

        }
        System.out.println(currentVertex);
        return true;
    }

    public static boolean isGraphPartite(ArrayList<Edge> graph[]) {
        int result[] = new int[graph.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        for (int i = 0; i < graph.length; i++) {
            if (result[i] == -1) {
                result[i] = 0;
                if (checkBiratiteGraph(graph, i, result)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int totalFirstVertex = 4;
        int totalSecondVertex = 5;
        ArrayList<Edge> firstGraph[] = new ArrayList[totalFirstVertex];
        ArrayList<Edge> secondGraph[] = new ArrayList[totalSecondVertex];
        createFirstGraph(firstGraph);
        createSecondGraph(secondGraph);

        System.out.println(isGraphPartite(secondGraph));

    }

}
