package GraphRevision;

import java.util.ArrayList;

public class BipartiteGraphDFS {

    public static boolean findBiparitieGraphs(ArrayList<ArrayList<Integer>> adj, int visited[], int source) {

        for (int i = 0; i < adj.get(source).size(); i++) {
            int dest = adj.get(source).get(i);
            if (visited[dest] == 0) {
                visited[dest] = visited[source] == 1 ? 2 : 1;
                if (findBiparitieGraphs(adj, visited, dest) == false) {
                    return false;
                }

            } else {
                if (visited[dest] == visited[source]) {
                    return false;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int V = 3, edges[][] = {
                { 0, 1 }, { 1, 2 }
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        int visited[] = new int[V];
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int sourceVertex = edges[i][0];
            int destVertex = edges[i][1];
            adj.get(sourceVertex).add(destVertex);
            adj.get(destVertex).add(sourceVertex);
        }
        visited[0] = 1;
        System.out.println(findBiparitieGraphs(adj, visited, 0));

    }

}
