package GraphStriver;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;;

public class wordLadderSeondBFS {

    static class Pair {
        ArrayList<String> sourcePath;
        int count;
        String src;

        Pair(ArrayList<String> sourcePath, String src, int count) {
            this.count = count;
            this.src = src;
            this.sourcePath = sourcePath;
        }
    }

    public static void findWordLis(ArrayList<ArrayList<String>> finalResult, ArrayList<String> wordList,
            String startWord,
            String targetWord) {
        Queue<Pair> que = new LinkedList<>();
        ArrayList<String> tempSet = new ArrayList<>();
        int minCount = Integer.MAX_VALUE;
        tempSet.add(startWord);
        que.add(new Pair(tempSet, startWord, 1));
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            int currentCount = pair.count;
            String curString = pair.src;
            ArrayList<String> tempResult = new ArrayList<>(pair.sourcePath);
            if (curString.equals(targetWord) && currentCount <= minCount) {
                finalResult.add(tempResult);
                minCount = currentCount;
            }
            if (minCount == Integer.MAX_VALUE) {
                for (int i = 0; i < curString.length(); i++) {
                    char temp[] = curString.toCharArray();
                    char tempChar = temp[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        temp[i] = j;
                        String newString = new String(temp);
                        if (!tempResult.contains(newString) && wordList.contains(newString)) {
                            tempResult.add(newString);
                            que.add(new Pair(new ArrayList<>(tempResult), newString, currentCount + 1));
                            tempResult.remove(newString);
                        }
                    }
                    temp[i] = tempChar;
                }

            }

        }

    }

    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String wordList[] = { "des", "der", "dfr", "dgt", "dfs" };
        ArrayList<String> word = new ArrayList<>();
        for (int i = 0; i < wordList.length; i++) {
            word.add(wordList[i]);
        }
        ArrayList<ArrayList<String>> finalResult = new ArrayList<>();
        findWordLis(finalResult, word, startWord, targetWord);
        System.out.println(finalResult);

    }

}
