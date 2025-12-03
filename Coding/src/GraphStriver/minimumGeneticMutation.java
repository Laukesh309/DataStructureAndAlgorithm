package GraphStriver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class minimumGeneticMutation {

    static class Pair {
        String source;
        int count;

        Pair(String source, int count) {
            this.count = count;
            this.source = source;
        }
    }

    public static int findMutation(String bank[], String startGene, String endGene, Set<String> set) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(startGene, 1));
        set.remove(startGene);
        char addArray[] = { 'A', 'C', 'G', 'T' };

        while (!que.isEmpty()) {
            Pair pair = que.poll();
            String curString = pair.source;
            int curCount = pair.count;
            if (curString.equals(endGene)) {
                return curCount;
            }

            char[] tempArray = curString.toCharArray();
            for (int i = 0; i < 8; i++) {
                char curChar = tempArray[i];
                for (int j = 0; j < addArray.length; j++) {
                    tempArray[i] = addArray[j];
                    String newString = new String(tempArray);
                    if (set.contains(newString)) {
                        que.add(new Pair(newString, curCount + 1));
                        set.remove(newString);
                    }
                }
                tempArray[i] = curChar;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        String startGene = "AACCGGTT", endGene = "AACCGGTA";
        String bank[] = { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
        Set<String> set = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            set.add(bank[i]);
        }
        System.out.println(findMutation(bank, startGene, endGene, set));
    }

}
