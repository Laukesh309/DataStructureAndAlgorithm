package GraphCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class topologicalSortBFS {

    static class Edge {
        int source;
        int dest;

        Edge(int source, int dest) {
            this.source = source;
            this.dest = dest;
        }
    }

    static class Pair {
        int order;
        int index;

        Pair(int order, int index) {
            this.order = order;
            this.index = index;
        }

    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topologicalSort(ArrayList<Edge> graph[]) {
        int incoming[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge edge = graph[i].get(j);
                incoming[edge.dest] = incoming[edge.dest] + 1;
            }
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < incoming.length; i++) {
            if (incoming[i] == 0) {
                que.add(i);
            }
        }
        while (!que.isEmpty()) {
            int currentIndex = que.remove();
            System.out.print(currentIndex + " ");
            for (int i = 0; i < graph[currentIndex].size(); i++) {
                Edge edge = graph[currentIndex].get(i);
                incoming[edge.dest]--;
                if (incoming[edge.dest] == 0) {
                    que.add(edge.dest);
                }
            }

        }
    }

    public static void main(String[] args) {
        int vertex = 6;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);
        topologicalSort(graph);

    }

}
