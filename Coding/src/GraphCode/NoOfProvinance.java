package GraphCode;

import java.util.List;
import java.util.Set;

import array.GeekForGeek.findPair;

import java.util.ArrayList;
import java.util.HashSet;

public class NoOfProvinance {

    static class DisJointSet2 {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisJointSet2(int V) {
            for (int i = 0; i < V; i++) {
                rank.add(0);
                parent.add(i);
            }
        }

        public int findParent(int n) {
            System.out.println("this is loadedc");
            if (n == parent.get(n)) {
                return n;
            }
            int tempParent = findParent(parent.get(n));
            parent.set(n, tempParent);
            return tempParent;
        }

        public void findUnioun(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);

            if (pu != pv) {
                if (rank.get(pu) < rank.get(pv)) {
                    parent.set(pu, parent.get(pv));
                } else if (rank.get(pu) > rank.get(pv)) {
                    parent.set(pv, parent.get(pu));
                } else {
                    parent.set(pu, parent.get(pv));
                    rank.set(pv, rank.get(pv) + 1);
                }
            }
        }
    }

    public static int findPath(ArrayList<ArrayList<Integer>> adj, int v) {
        DisJointSet2 djs = new DisJointSet2(v);

        for (int i = 0; i < v; i++) {
            int currentVertex = i;
            for (int j = 0; j < adj.get(currentVertex).size(); j++) {
                int secondVertex = adj.get(currentVertex).get(j);
                if (secondVertex == 1) {
                    djs.findUnioun(currentVertex, j);
                }

            }
        }
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < djs.parent.size(); i++) {
            int currentParent = djs.parent.get(i);
            result.add(currentParent);
        }
        System.out.println(result.size());
        return result.size();

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int edges[][] = { { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 } };
        for (int i = 0; i < edges.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < edges[0].length; j++) {
                temp.add(edges[i][j]);
            }
            adj.add(temp);
        }
        findPath(adj, 3);

    }

}
