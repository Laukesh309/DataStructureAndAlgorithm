package GraphStriver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class wordLadder1 {

    static class Pair {
        String word;
        int count;

        Pair(String word, int count) {
            this.count = count;
            this.word = word;
        }
    }

    public static int totatPath(String startWord, int currentIndex, String targetWord, int count,
            Set<String> finalSet) {
        System.out.println(startWord + " " + currentIndex);
        if (targetWord.equals(startWord)) {
            return count;
        }
        if (currentIndex >= startWord.length()) {
            return Integer.MAX_VALUE;
        }
        int minResult = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            char temp = (char) ('a' + i);
            StringBuilder sb = new StringBuilder(startWord);
            sb.setCharAt(currentIndex, temp);
            minResult = Math.min(minResult,
                    totatPath(sb.toString(), currentIndex + 1, targetWord, count + 1, finalSet));

        }
        return minResult;
    }

    public static int totalPathBFS(String startWord, String targetWord, Set<String> finalSet) {

        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(startWord, 1));
        finalSet.remove(startWord);
        while (!que.isEmpty()) {
            Pair curPair = que.remove();
            String curString = curPair.word;
            int curStep = curPair.count;
            if (curString.equals(targetWord)) {
                return curStep;
            }
            for (int i = 0; i < curString.length(); i++) {
                StringBuilder sb = new StringBuilder(curString);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    sb.setCharAt(i, ch);
                    if (finalSet.contains(sb.toString())) {
                        finalSet.remove(sb.toString());
                        que.add(new Pair(sb.toString(), curStep + 1));
                    }
                }
            }

        }
        return 0;

    }

    public static void main(String[] args) {
        String startWord = "gedk";
        String targetWord = "geek";
        String wordList[] = { "geek", "gefk" };
        Set<String> finalWordList = new HashSet<>();
        for (String string : wordList) {
            finalWordList.add(string);
        }
        // System.out.println(totatPath(startWord, 0, targetWord, 0, finalWordList));
        System.out.println(totalPathBFS(startWord, targetWord, finalWordList));

    }

}
