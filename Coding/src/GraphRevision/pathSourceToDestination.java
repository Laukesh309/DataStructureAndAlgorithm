package GraphRevision;

import java.util.ArrayList;

public class pathSourceToDestination {

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
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    public static void printPath(ArrayList<Edge> graph[], int currentVertex, ArrayList<Integer> path, int target) {
        if (currentVertex >= graph.length) {
            return;
        }
        if (currentVertex == target) {
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[currentVertex].size(); i++) {
            Edge currEdge = graph[currentVertex].get(i);
            path.add(currEdge.dest);
            printPath(graph, currEdge.dest, path, target);
            path.remove(path.size() - 1);
        }
        return;

    }

    public static void main(String[] args) {
        int vertex = 6;
        int source = 5;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);
        ArrayList<Integer> path = new ArrayList<>();
        path.add(source);
        printPath(graph, source, path, 1);

    }

}
