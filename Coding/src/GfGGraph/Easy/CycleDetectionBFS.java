package GfGGraph.Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectionBFS {

    static class Pair {
        int source;
        int parent;

        Pair(int source, int parent) {
            this.source = source;
            this.parent = parent;
        }
    }

    public static void formGraph(int edges[][], ArrayList<ArrayList<Integer>> graph, int V) {

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int souce = edges[i][0];
            int dest = edges[i][1];
            graph.get(souce).add(dest);
            graph.get(dest).add(souce);
        }

    }

    public static boolean findCycle(ArrayList<ArrayList<Integer>> graph, int V) {
        Queue<Pair> que = new LinkedList<>();
        boolean visited[] = new boolean[V];

        for (int v = 0; v < V; v++) {
            if (!visited[v]) {
                que.add(new Pair(v, -1));
                visited[v] = true;
                while (!que.isEmpty()) {
                    Pair pair = que.poll();
                    int souce = pair.source;
                    int parent = pair.parent;
                    System.out.println("testing");
                    for (int i = 0; i < graph.get(souce).size(); i++) {
                        int neighbhor = graph.get(souce).get(i);
                        if (!visited[neighbhor]) {
                            que.add(new Pair(neighbhor, souce));
                            visited[neighbhor] = true;
                        } else if (visited[neighbhor] == true && neighbhor != parent) {
                            return true;
                        } else {

                        }
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int edges[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
        int V = 4;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);
        formGraph(edges, graph, V);
        System.out.println(findCycle(graph, V));

    }

}
