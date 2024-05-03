package GraphCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortKenns {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
    }

    public static void printArray(int inOrder[]) {
        for (int i = 0; i < inOrder.length; i++) {
            System.out.print(inOrder[i] + " ");
        }
    }

    public static void findInOrder(ArrayList<Edge> graph[], int inOrder[]) {
        for (int i = 0; i < graph.length; i++) {
            int currentVertex = i;
            for (int j = 0; j < graph[currentVertex].size(); j++) {
                Edge edge = graph[currentVertex].get(j);
                inOrder[edge.dest] = inOrder[edge.dest] + 1;
            }
        }

    }

    public static void topologicalSort(ArrayList<Edge> graph[]) {
        int inOrder[] = new int[graph.length];
        findInOrder(graph, inOrder);

        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == 0) {
                que.add(i);
            }
        }

        /// perform BFS
        while (!que.isEmpty()) {
            int currentVertex = que.remove();
            System.out.print(currentVertex + " ");
            for (int i = 0; i < graph[currentVertex].size(); i++) {
                Edge edg = graph[currentVertex].get(i);
                inOrder[edg.dest] = inOrder[edg.dest] - 1;
                if (inOrder[edg.dest] == 0) {
                    que.add(edg.dest);
                }
            }

        }

    }

    public static void main(String[] args) {

        int totalVertext = 6;
        ArrayList<Edge> graph[] = new ArrayList[totalVertext];
        createGraph(graph);
        topologicalSort(graph);
    }

}
