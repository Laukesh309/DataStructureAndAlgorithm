package GraphCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class biratiteGraph {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static boolean buildBiratiteGraph(ArrayList<Edge> graph[], int result[]) {
        Queue<Integer> que = new LinkedList();
        que.add(0);
        result[0] = 0;
        while (!que.isEmpty()) {
            int currentVertext = que.remove();
            for (int i = 0; i < graph[currentVertext].size(); i++) {
                int dest = graph[currentVertext].get(i).dest;
                int currentColor = result[currentVertext];
                if (result[dest] == -1) {
                    que.add(dest);
                    if (currentColor == 0) {
                        result[dest] = 1;
                    } else {
                        result[dest] = 0;
                    }
                } else if (result[currentVertext] == result[dest]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int totalVertext = 5;
        ArrayList<Edge> graph[] = new ArrayList[totalVertext];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList();
        }
        int result[] = new int[graph.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }

        graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        // graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 2));
        System.out.println(buildBiratiteGraph(graph, result));

    }

}
