package GraphStriver;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

class DisJointSet4 {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisJointSet4(int vertex) {
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

    public void union(int u, int v) {
        int uParent = findParent(u);
        int vParent = findParent(v);
        if (uParent == vParent) {
            return;
        }
        if (rank.get(uParent) < rank.get(vParent)) {
            parent.set(uParent, parent.get(vParent));
        } else if (rank.get(uParent) > rank.get(vParent)) {
            parent.set(vParent, parent.get(uParent));
        } else {
            parent.set(uParent, parent.get(vParent));
            rank.set(vParent, rank.get(vParent) + 1);
        }
    }
}

public class AccountMerge {

    public static ArrayList<ArrayList<String>> createAccount() {
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();
        String temp[][] = { { "John", "johnsmith@mail.com", "john_newyork@mail.com" },
                { "John", "johnsmith@mail.com", "john00@mail.com" },
                { "Mary", "mary@mail.com" },
                { "John", "johnnybravo@mail.com" } };
        for (int i = 0; i < temp.length; i++) {
            accounts.add(new ArrayList<>());
        }

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                accounts.get(i).add(temp[i][j]);
            }
        }
        return accounts;
    }

    public static void mergeAccount(ArrayList<ArrayList<String>> accounts) {
        int vertex = accounts.size();
        DisJointSet4 ds = new DisJointSet4(vertex);
        HashMap<String, Integer> hs = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            ArrayList<String> tempArray = accounts.get(i);
            for (int j = 1; j < tempArray.size(); j++) {
                if (hs.containsKey(tempArray.get(j))) {
                    int Node = hs.get(tempArray.get(j));
                    ds.union(Node, i);
                } else {
                    hs.put(tempArray.get(j), i);
                }
            }
        }
        ArrayList<ArrayList<String>> finalResult = new ArrayList<>(vertex);
        for (int i = 0; i < vertex; i++) {
            finalResult.add(new ArrayList<>());
        }
        hs.forEach((key, value) -> {
            int uParent = ds.findParent(value);
            ArrayList<String> tempString = finalResult.get(uParent);
            tempString.add(key);
            Collections.sort(tempString);
            finalResult.set(uParent, tempString);
        });
        for (int i = 0; i < finalResult.size(); i++) {
            if (finalResult.get(i).isEmpty()) {
                continue;

            } else {
                String name = accounts.get(i).get(0);
                finalResult.get(i).add(0, name);
            }
        }
        finalResult.removeIf(List::isEmpty);
        return finalResult;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> accounts = createAccount();
        mergeAccount(accounts);
    }

}
