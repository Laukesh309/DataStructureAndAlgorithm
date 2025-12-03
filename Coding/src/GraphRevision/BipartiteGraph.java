package GraphRevision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BipartiteGraph {

    static class Edge {
        int source;
        int destination;

        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 2));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));

    }

    public static boolean checkBipartitle(ArrayList<Edge> graph[], int source) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int color[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            color[i] = -1;
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        color[source] = 0;
        set2.add(source);
        while (!que.isEmpty()) {
            int currentVertext = que.remove();
            int currentColor = color[currentVertext];
            for (int i = 0; i < graph[currentVertext].size(); i++) {
                Edge edge = graph[currentVertext].get(i);
                if (color[edge.destination] == -1) {
                    que.add(edge.destination);
                    if (currentColor == 0) {
                        color[edge.destination] = 1;
                        set1.add(edge.destination);
                    } else {
                        color[edge.destination] = 0;
                        set2.add(edge.destination);
                    }
                }
                if (color[edge.destination] != -1 && color[edge.destination] == currentColor) {
                    return false;
                }

            }

        }
        System.out.println(set1);
        System.out.println(set2);
        return true;
    }

    public static void main(String[] args) {
        int vertex = 5;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph);
        System.out.println(checkBipartitle(graph, 0));

    }

}
