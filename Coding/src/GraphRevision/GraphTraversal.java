package GraphRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {

    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void createGraph(ArrayList<Edge> edge[]) {
        for (int i = 0; i < edge.length; i++) {
            edge[i] = new ArrayList<Edge>();
        }

        edge[0].add(new Edge(0, 1, 1));
        edge[0].add(new Edge(0, 2, 1));

        edge[1].add(new Edge(1, 0, 1));
        edge[1].add(new Edge(1, 3, 1));

        edge[2].add(new Edge(2, 0, 1));
        edge[2].add(new Edge(2, 4, 1));

        edge[3].add(new Edge(3, 1, 1));
        edge[3].add(new Edge(3, 4, 1));
        edge[3].add(new Edge(3, 5, 1));

        edge[4].add(new Edge(4, 5, 1));
        edge[4].add(new Edge(4, 2, 1));
        edge[4].add(new Edge(4, 3, 1));

        edge[5].add(new Edge(5, 3, 1));
        edge[5].add(new Edge(5, 4, 1));
        edge[5].add(new Edge(5, 6, 1));

        edge[6].add(new Edge(6, 5, 1));

    }

    public static void printBFS(ArrayList<Edge> edge[]) {
        Queue<Integer> que = new LinkedList<>();
        boolean visited[] = new boolean[edge.length];
        que.add(3);
        while (!que.isEmpty()) {
            int currentVertext = que.remove();
            for (int i = 0; i < edge[currentVertext].size(); i++) {
                Edge currEdge = edge[currentVertext].get(i);
                int dest = currEdge.destination;
                if (visited[dest] == false) {
                    que.add(dest);
                }

            }
            visited[currentVertext] = true;
            System.out.print(currentVertext + "   ");
        }

    }

    public static void printDFS(ArrayList<Edge> edge[], int currentSource, boolean visited[]) {
        if (visited[currentSource] == true) {
            return;
        }
        System.out.print(currentSource + "  ");
        visited[currentSource] = true;
        for (int i = 0; i < edge[currentSource].size(); i++) {
            Edge currentDestination = edge[currentSource].get(i);
            printDFS(edge, currentDestination.destination, visited);
        }
        return;
    }

    public static boolean hasPath(ArrayList<Edge> edges[], int currentSource, boolean visited[], int target) {
        if (currentSource == target) {
            return true;
        }
        if (visited[currentSource] == true) {
            return false;
        }
        visited[currentSource] = true;
        for (int i = 0; i < edges[currentSource].size(); i++) {
            Edge currDest = edges[currentSource].get(i);
            if (hasPath(edges, currDest.destination, visited, target)) {
                return true;
            }
        }
        return false;
    }

    public static boolean detectCycleUtil(ArrayList<Edge> edge[], int currentSource, boolean visited[], int parent) {

        visited[currentSource] = true;
        for (int i = 0; i < edge[currentSource].size(); i++) {
            Edge currentEdge = edge[currentSource].get(i);
            int currentDest = currentEdge.destination;
            if (visited[currentDest] == true && currentDest != parent) {
                return true;
            }
            if (visited[currentDest] != true) {
                if (detectCycleUtil(edge, currentDest, visited, currentSource)) {
                    return true;
                }
            }

        }
        return false;

    }

    public static boolean detectCycle(ArrayList<Edge> edge[], int currentSource, boolean visited[]) {

        visited[currentSource] = true;
        for (int i = 0; i < edge[currentSource].size(); i++) {
            Edge currentEdge = edge[currentSource].get(i);
            if (!visited[currentEdge.destination]) {
                if (detectCycleUtil(edge, currentEdge.destination, visited, currentSource)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {

        int vertex = 7;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        boolean visited[] = new boolean[vertex];
        createGraph(graph);
        // printBFS(graph);
        // printDFS(graph, 0, visited);
        // System.out.println(hasPath(graph, 0, visited, 8));
        System.out.println(detectCycle(graph, 0, visited));
    }

}
