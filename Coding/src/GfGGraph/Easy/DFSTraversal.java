package GfGGraph.Easy;

import java.util.ArrayList;

import HashMap.validAnagram;

public class DFSTraversal {

    public static void findDFS(ArrayList<ArrayList<Integer>> adj, int currentIndex, boolean visited[],
            ArrayList<Integer> finalResult) {
        visited[currentIndex] = true;
        finalResult.add(currentIndex);
        for (int i = 0; i < adj.get(currentIndex).size(); i++) {
            int neighbour = adj.get(currentIndex).get(i);
            if (visited[neighbour] == false) {
                findDFS(adj, neighbour, visited, finalResult);
            }
        }
        return;
    }

    public static void main(String[] args) {
        int adj[][] = { { 2, 3, 1 }, { 0 }, { 0, 4 }, { 0 }, { 2 } };
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < adj.length; i++) {
            ArrayList<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < adj[i].length; j++) {
                int currentIndex = adj[i][j];
                tempList.add(currentIndex);
            }
            graph.add(tempList);
        }
        boolean visited[] = new boolean[adj.length];
        ArrayList<Integer> finalResult = new ArrayList<>();
        findDFS(graph, 0, visited, finalResult);
        System.out.println(finalResult);
    }
}
