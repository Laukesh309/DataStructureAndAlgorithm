package GraphStriver;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

class DisjointSet2 {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet2(int vertex) {
        for (int i = 0; i < vertex; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int n) {
        if (n == parent.get(n)) {
            return n;
        } else {
            int tempParent = findParent(parent.get(n));
            parent.set(n, tempParent);
            return tempParent;
        }
    }

    public void findUnioun(int u, int v) {
        int uParent = findParent(u);
        int vParent = findParent(v);
        if (uParent == vParent) {
            return;
        }
        if (rank.get(uParent) < rank.get(vParent)) {
            parent.set(uParent, vParent);
        } else if (rank.get(uParent) > rank.get(vParent)) {
            parent.set(vParent, uParent);
        } else {
            parent.set(uParent, vParent);
            rank.set(vParent, rank.get(vParent) + 1);
        }
    }
}

public class NoOfProvinance {

    public int findProvinance(ArrayList<ArrayList<Integer>> adj, int vertex) {
        DisjointSet2 ds = new DisjointSet2(vertex);
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                if (adj.get(i).get(j) == 1) {
                    ds.findUnioun(i, j);
                }
            }
        }
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < ds.parent.size(); i++) {
            result.add(ds.parent.get(i));
        }
        return result.size();
    }

    public static void main(String[] args) {

    }

}
