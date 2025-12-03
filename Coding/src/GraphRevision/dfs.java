package GraphRevision;

import java.util.ArrayList;

public class dfs {

    public static void findDfs(ArrayList<ArrayList<Integer>> adj, boolean visited[], int currentSource,
            ArrayList<Integer> result) {
        visited[currentSource] = true;
        result.add(currentSource);
        for (int i = 0; i < adj.get(currentSource).size(); i++) {
            int dest = adj.get(currentSource).get(i);
            if (!visited[dest]) {
                findDfs(adj, visited, dest, result);
            }
        }

    }

    public static void main(String[] args) {
        int tempData[][] = { { 2, 3, 1 }, { 0 }, { 0, 4 }, { 0 }, { 2 } };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int row = 0; row < tempData.length; row++) {
            ArrayList<Integer> tempResult = new ArrayList<>();
            for (int column = 0; column < tempData[row].length; column++) {
                tempResult.add(tempData[row][column]);
            }
            adj.add(tempResult);
        }
        boolean visited[] = new boolean[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();
        findDfs(adj, visited, 0, result);
        System.out.println(result);

    }
}
