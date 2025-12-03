package GraphStriver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;

public class wordLadder {

    static class Pair {
        String str;
        int count;

        Pair(String str, int count) {
            this.str = str;
            this.count = count;
        }
    }

    public static int findMinLenth(String wordList[], String startWord, String targetWord,
            Set<String> set) {
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(startWord, 1));
        ArrayList<Integer> finalResult = new ArrayList<>();
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            String curWord = pair.str;
            int currentCount = pair.count;
            set.remove(curWord);
            if (curWord.equals(targetWord)) {
                return currentCount;
            }
            System.out.println(set);
            char tempArr[] = curWord.toCharArray();
            for (int i = 0; i < curWord.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    tempArr[i] = j;
                    String newString = new String(tempArr);
                    if (set.contains(newString)) {
                        System.out.println(newString);
                        que.add(new Pair(newString, currentCount + 1));
                    }
                }
                tempArr = curWord.toCharArray();

            }
        }
        return 0;

    }

    public static void main(String[] args) {
        String wordList[] = { "geek", "gefk" };
        Set<String> set = new HashSet<>();
        for (String string : wordList) {
            set.add(string);

        }
        System.out.println(set);
        String startWord = "gedk", targetWord = "geek";
        findMinLenth(wordList, startWord, targetWord, set);
    }

}
