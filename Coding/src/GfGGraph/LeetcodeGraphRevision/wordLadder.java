package GfGGraph.LeetcodeGraphRevision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class wordLadder {

    public static int findMinTransfer(String beginWord, String endWord, List<String> wordList) {
        Set<String> st = new HashSet<>(wordList);
        Queue<String> que = new LinkedList<>();
        que.add(beginWord);
        int totalSize = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            System.out.println(que);
            for (int i = 0; i < size; i++) {
                String tempString = que.poll();
                if (tempString.equals(endWord)) {
                    return totalSize + 1;
                }

                for (int j = 0; j < tempString.length(); j++) {
                    char charArray[] = tempString.toCharArray();
                    for (char ch = 'a'; ch < 'z'; ch++) {
                        charArray[j] = ch;
                        String newString = new String(charArray);
                        System.out.println("newString " + newString);
                        if (st.contains(newString)) {
                            System.out.println("this is inside");
                            que.add(newString);
                            st.remove(newString);
                        }

                    }
                }
            }
            totalSize++;

        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String wordList[] = { "hot", "dot", "dog", "lot", "log", "cog" };

        List<String> tempList = new ArrayList<>(Arrays.asList(wordList));
        System.out.println(tempList);

        System.out.println(findMinTransfer(beginWord, endWord, tempList));

    }

}
