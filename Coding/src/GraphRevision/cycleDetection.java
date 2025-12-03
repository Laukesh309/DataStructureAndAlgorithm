package GraphRevision;

import java.util.ArrayList;

public class cycleDetection {

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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static boolean findCycleUtil(ArrayList<Edge> graph[], int currentVertes, boolean visited[], int parent) {

        visited[currentVertes] = true;
        for (int i = 0; i < graph[currentVertes].size(); i++) {
            Edge curEdge = graph[currentVertes].get(i);
            if (visited[curEdge.dest] == true && curEdge.dest != parent) {
                return true;
            }
            if (!visited[curEdge.dest]) {
                if (findCycleUtil(graph, curEdge.dest, visited, currentVertes)) {
                    return true;
                }

            }
        }
        return false;
    }

    public static boolean findCycle(ArrayList<Edge> graph[], boolean visited[]) {

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (findCycleUtil(graph, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int vertex = 5;
        boolean visited[] = new boolean[vertex];
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);
        System.out.println(findCycle(graph, visited));

    }

}
