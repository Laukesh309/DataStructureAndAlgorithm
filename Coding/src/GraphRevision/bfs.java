package GraphRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class bfs {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int temp[][] = { { 2, 3, 1 }, { 0 }, { 0, 4 }, { 0 }, { 2 } };
        for (int i = 0; i < temp.length; i++) {
            ArrayList<Integer> tempResult = new ArrayList<>();
            for (int j = 0; j < temp[i].length; j++) {
                tempResult.add(temp[i][j]);
            }
            adj.add(tempResult);
        }

        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> tempQue = new LinkedList<>();
        int totalVertex = adj.size();
        boolean visited[] = new boolean[totalVertex];
        tempQue.add(0);
        visited[0] = true;
        while (!tempQue.isEmpty()) {
            int currentSouce = tempQue.poll();
            result.add(currentSouce);
            for (int i = 0; i < adj.get(currentSouce).size(); i++) {
                int dest = adj.get(currentSouce).get(i);
                if (!visited[dest]) {
                    visited[dest] = true;
                    tempQue.add(dest);
                }
            }
        }
        System.out.println(result);
    }

}
