package GfGGraph.Medium;

import java.util.ArrayList;
import java.util.Arrays;

public class PossiblePath {

    public static int findAllPossiblePath(ArrayList<ArrayList<Integer>> adj, int source, int destination) {
        if (source == destination) {
            return 1;
        }
        int total = 0;
        for (int i = 0; i < adj.get(source).size(); i++) {
            int neighbour = adj.get(source).get(i);
            total += findAllPossiblePath(adj, neighbour, destination);
        }
        return total;
    }

    public static void main(String[] args) {

        int V = 5;
        int graph[][] = { { 1, 2, 4 }, { 3, 4 }, { 4 }, { 2 }, {} };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < graph.length; i++) {
            ArrayList<Integer> tempArray = new ArrayList<>();
            for (int j = 0; j < graph[i].length; j++) {
                tempArray.add(graph[i][j]);
            }
            adj.add(tempArray);
        }
        int source = 0;
        int destination = 4;
        System.out.println(findAllPossiblePath(adj, source, destination));
    }

}
