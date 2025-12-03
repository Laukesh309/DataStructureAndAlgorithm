package GraphRevision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BipartiteGraph1 {

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
            graph[i] = new ArrayList();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 2));

    }

    public static boolean isBipartiteGraph(ArrayList<Edge> graph[], int source) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int color[] = new int[graph.length];
        Queue<Integer> que = new LinkedList<>();
        que.add(source);
        color[source] = 1;
        while (!que.isEmpty()) {
            int currentindex = que.remove();
            for (int i = 0; i < graph[currentindex].size(); i++) {
                int dest = graph[currentindex].get(i).dest;
                if (color[dest] != 0) {
                    if (color[dest] == color[currentindex]) {
                        return false;
                    }
                } else {
                    que.add(dest);
                    color[dest] = color[currentindex] == 1 ? 2 : 1;
                }
            }
            if (color[currentindex] == 1) {
                set1.add(currentindex);
            } else {
                set2.add(currentindex);
            }
        }
        System.out.println(set1);
        System.out.println(set2);
        return true;

    }

    public static void main(String[] args) {
        int vertex = 5;
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        createGraph(graph);
        System.out.println(isBipartiteGraph(graph, 0));
    }

}
