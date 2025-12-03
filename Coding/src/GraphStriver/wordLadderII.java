package GraphStriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class wordLadderII {
    static class Pair {
        String str;
        ArrayList<String> result;

        Pair(String str, ArrayList<String> result) {
            this.str = str;
            this.result = result;
        }
    }

    public static void findString(String startWord, Set<String> st, String targetWord) {

        ArrayList<ArrayList<String>> finalResult = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        Queue<Pair> que = new LinkedList<>();
        result.add(startWord);
        que.add(new Pair(startWord, result));
        int min = Integer.MAX_VALUE;
        while (!que.isEmpty()) {
            Pair curPair = que.remove();
            String curString = curPair.str;
            ArrayList<String> curResult = curPair.result;
            if (curString.equals(targetWord)) {
                if (curResult.size() <= min) {
                    min = curResult.size();
                    finalResult.add(curResult);
                    continue;
                } else {
                    break;
                }
            }
            for (int i = 0; i < curString.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    StringBuilder sb = new StringBuilder(curString);
                    sb.setCharAt(i, ch);
                    if (!curResult.contains(sb.toString()) && st.contains(sb.toString())) {
                        curResult.add(sb.toString());
                        que.add(new Pair(sb.toString(), new ArrayList<>(curResult)));
                        curResult.remove(curResult.size() - 1);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String wordList[] = { "des", "der", "dfr", "dgt", "dfs" };
        Set<String> st = new HashSet<>(Arrays.asList(wordList));
        findString(startWord, st, targetWord);
    }

}
