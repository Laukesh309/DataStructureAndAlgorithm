package GraphRevision;

import java.util.ArrayList;;

public class provinance {

    public static void findDfs(ArrayList<ArrayList<Integer>> adj, int currentSouce, boolean visited[]) {
        visited[currentSouce] = true;
        for (int i = 0; i < adj.size(); i++) {
            int tempDest = adj.get(currentSouce).get(i);
            if (tempDest == 1) {
                if (!visited[i]) {
                    findDfs(adj, i, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        int rowData[][] = {
                { 1, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 1 },
                { 0, 0, 0, 1, 0 },
                { 0, 0, 1, 0, 1 }
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < rowData.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < rowData.length; j++) {
                temp.add(rowData[i][j]);
            }
            adj.add(temp);
        }
        boolean visited[] = new boolean[adj.size()];
        int count = 0;
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                count++;
                findDfs(adj, i, visited);
            }
        }
        System.out.println(count);

    }
}
