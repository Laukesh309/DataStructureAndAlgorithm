package GraphCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFST {
    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void bfsTraversal(ArrayList<Edge> graph[], int totalVertext, int inititalVertext) {
        boolean visited[] = new boolean[totalVertext];
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(inititalVertext);
        while (!que.isEmpty()) {
            int currentVertex = que.remove();
            if (!visited[currentVertex]) {
                System.out.print(currentVertex + " ");
                visited[currentVertex] = true;
                for (int i = 0; i < graph[currentVertex].size(); i++) {
                    que.add(graph[currentVertex].get(i).dest);
                }
            }

        }

    }

    public static void printChild(ArrayList<Edge> graph[], int vertex) {
        for (int i = 0; i < graph[vertex].size(); i++) {
            System.out.print(graph[vertex].get(i).dest + " ");
        }
        System.out.println();
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
        // printChild(graph, 2);
        bfsTraversal(graph, vertex, 3);

    }

}
