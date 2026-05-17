package GfGGraph.LeetcodeGraphRevision;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class minimumGeneticMutation {
    static class Pair {
        StringBuilder sb;
        int currentIndex;

        Pair(StringBuilder sb, int currentIndex) {
            this.sb = sb;
            this.currentIndex = currentIndex;
        }
    }

    public static int findMinMutation(String startGene, String endGene, String[] bank) {
        Set<String> st = new HashSet<>();
        for (String string : bank) {
            st.add(string);
        }
        StringBuilder sb = new StringBuilder(startGene);
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(sb, 0));
        int totalLevel = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int row = 0; row < size; row++) {
                Pair pair = que.poll();
                StringBuilder tempString = pair.sb;
                System.out.println(tempString);
                if (tempString.toString().equals(endGene)) {
                    System.out.println(totalLevel);
                    return totalLevel;
                }
                for (int k = 0; k < startGene.length(); k++) {
                    char ch[] = { 'A', 'C', 'G', 'T' };
                    char currentch = tempString.charAt(k);
                    for (int i = 0; i < ch.length; i++) {
                        char currentChar = ch[i];
                        tempString.setCharAt(k, currentChar);
                        if (st.contains(tempString.toString())) {
                            que.add(new Pair(new StringBuilder(tempString), k + 1));
                            st.remove(tempString.toString());
                        }
                    }
                    tempString.setCharAt(k, currentch);
                }

            }
            totalLevel++;
        }

        return 0;

    }

    public static void main(String[] args) {

        String startGene = "AACCGGTT";
        String endGene = "AACCGGTA";
        String[] bank = { "AACCGGTA" };
        findMinMutation(startGene, endGene, bank);

    }

}
