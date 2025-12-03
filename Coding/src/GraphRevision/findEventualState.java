package GraphRevision;

import java.util.ArrayList;
import java.util.Collections;

public class findEventualState {

    public static boolean findDfsCycle(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> path, int source) {

        path.add(source);
        for (int i = 0; i < adj.get(source).size(); i++) {
            int dest = adj.get(source).get(i);
            if (path.contains(dest)) {
                return true;
            } else {
                if (findDfsCycle(adj, path, dest)) {
                    return true;
                }
            }
        }
        path.remove(path.size() - 1);
        return false;

    }

    public static void findStateUtil(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (!findDfsCycle(adj, new ArrayList<>(), i)) {
                result.add(i);
            }
        }
        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int temp[][] = { { 1, 2 }, { 3, 2 }, { 5 }, { 0 }, { 5 }, {}, {} };
        int V = 7;
        for (int i = 0; i < V; i++) {
            ArrayList<Integer> tempArr = new ArrayList<>();
            for (int j = 0; j < temp[i].length; j++) {
                tempArr.add(temp[i][j]);
            }
            adj.add(tempArr);
        }
        findStateUtil(adj, V);
    }

}
