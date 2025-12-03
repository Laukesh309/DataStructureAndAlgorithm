package GraphRevision;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class mergingDetails {

    static class Disjoint4 {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        Disjoint4(int v) {
            for (int i = 0; i < v; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        public int findParent(int n) {
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
                    parent.set(pu, pv);
                } else if (rank.get(pu) > rank.get(pv)) {
                    parent.set(pv, pu);
                } else {
                    parent.set(pu, pv);
                    rank.set(pv, rank.get(pv) + 1);
                }
            }
        }
    }

    public static void findTempUnioun(List<List<String>> details) {
        HashMap<String, Integer> hm = new HashMap<>();
        Disjoint4 ds = new Disjoint4(details.size());
        for (int i = 0; i < details.size(); i++) {
            List<String> tempString = details.get(i);
            for (int j = 1; j < tempString.size(); j++) {
                String email = tempString.get(j);
                if (hm.containsKey(email)) {
                    int parentKey = hm.get(email);
                    int currentKey = i;
                    ds.findUnioun(currentKey, parentKey);
                } else {
                    ds.findUnioun(i, i);
                    hm.put(email, i);
                }
            }
        }
        HashMap<Integer, ArrayList<String>> finalResult = new HashMap<>();

        Set<String> keys = hm.keySet();
        for (String key : keys) {
            int index = ds.findParent(hm.get(key));
            if (finalResult.containsKey(index)) {
                finalResult.get(index).add(key);
            } else {
                ArrayList<String> tempString = new ArrayList<>();
                tempString.add(key);
                finalResult.put(index, tempString);
            }
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (Integer temp : finalResult.keySet()) {
            String parent = details.get(temp).get(0);
            ArrayList<String> tempString = new ArrayList<>(finalResult.get(temp));
            Collections.sort(tempString);
            tempString.add(0, parent);
            result.add(tempString);

        }
        System.out.println(result);
        // ArrayList<ArrayList<String>> result = new ArrayList<>();
        // for (int i = 0; i < details.size(); i++) {
        // result.add(new ArrayList<>());
        // }
        // Set<String> keys = hm.keySet();
        // for (String key : keys) {
        // int index = ds.findParent(hm.get(key));
        // if (result.get(index).size() > 0) {
        // result.get(index).add(key);
        // } else {
        // result.get(index).add(details.get(index).get(0));
        // result.get(index).add(key);
        // }
        // }
        // System.out.println(result);
    }

    public static void main(String[] args) {

        String temp[][] = { { "John", "johnsmith@mail.com", "john_newyork@mail.com" },
                { "John", "johnsmith@mail.com", "john00@mail.com" },
                { "Mary", "mary@mail.com" },
                { "John", "johnnybravo@mail.com" }
        };
        List<List<String>> details = new ArrayList<>();
        for (int i = 0; i < temp.length; i++) {
            ArrayList<String> tempStr = new ArrayList<>();
            for (int j = 0; j < temp[i].length; j++) {
                tempStr.add(temp[i][j]);
            }
            details.add(tempStr);
        }
        findTempUnioun(details);
    }
}
