package GraphCode;

import java.util.ArrayList;

public class HasPath {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean hasPath(ArrayList<Edge> graph[], int dest, int currentVertex, boolean visited[]) {
        visited[currentVertex] = true;
        if (currentVertex == dest) {
            return true;
        }
        for (int i = 0; i < graph[currentVertex].size(); i++) {
            int childVertex = graph[currentVertex].get(i).dest;
            if (!visited[childVertex] && hasPath(graph, dest, childVertex, visited)) {
                System.out.print(childVertex + "=>");
                return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        int vertex = 7;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 4));
        graph[2].add(new Edge(2, 0));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));
        boolean visited[] = new boolean[vertex];
        System.out.println(hasPath(graph, 6, 0, visited));

    }

}
