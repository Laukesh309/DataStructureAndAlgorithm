package BackTrackingGFG.Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import GraphRevision.floodFills;

public class mColoring {

    public static void makeAdjecencyList(int edges[][], ArrayList<ArrayList<Integer>> adj) {
        for (int row = 0; row < edges.length; row++) {
            int source = edges[row][0];
            int dest = edges[row][1];
            adj.get(source).add(dest);
            adj.get(dest).add(source);
        }
    }

    public static boolean checkSafe(ArrayList<ArrayList<Integer>> adj, int currentVertex, int color[],
            int currentValue) {
        ArrayList<Integer> curAdjVartex = adj.get(currentVertex);
        for (int i = 0; i < curAdjVartex.size(); i++) {
            if (color[curAdjVartex.get(i)] == currentValue) {
                return false;
            }
        }
        return true;

    }

    public static boolean findColoring(ArrayList<ArrayList<Integer>> adj, int totalVertex, int m,
            int currentVertex, int colorArray[]) {

        if (currentVertex == totalVertex) {
            return true;
        }
        for (int i = 0; i < m; i++) {
            if (checkSafe(adj, currentVertex, colorArray, i)) {
                colorArray[currentVertex] = i;
                if (findColoring(adj, totalVertex, m, currentVertex + 1, colorArray)) {
                    return true;
                }
                colorArray[currentVertex] = -1;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int v = 3;
        int m = 2;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        int edges[][] = { { 0, 1 }, { 1, 2 }, { 0, 2 } };
        makeAdjecencyList(edges, adj);
        int colorArray[] = new int[v];
        Arrays.fill(colorArray, -1);
        System.out.println(adj);
        System.out.println(findColoring(adj, v, m, 0, colorArray));

    }
}
