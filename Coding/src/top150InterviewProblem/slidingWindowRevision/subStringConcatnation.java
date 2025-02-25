// https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/?envType=study-plan-v2&envId=top-interview-150
package top150InterviewProblem.slidingWindowRevision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class subStringConcatnation {

    public static List<Integer> findIndex(String str, String words[]) {

        int wordLenght = words[0].length();
        int totalWindow = wordLenght * words.length;
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> hs = new HashMap<>();
        for (String string : words) {
            hs.put(string, hs.getOrDefault(string, 0) + 1);
        }
        for (int i = 0; i <= str.length() - totalWindow; i++) {
            HashMap<String, Integer> currentHashMap = new HashMap<>(hs);
            int j = i;
            if (j + totalWindow <= str.length()) {
                while (j <= i + totalWindow) {
                    String currentSubString = str.substring(j, j + wordLenght);
                    if (currentHashMap.containsKey(currentSubString)) {
                        currentHashMap.put(currentSubString, currentHashMap.get(currentSubString) -
                                1);
                        if (currentHashMap.get(currentSubString) == 0) {
                            currentHashMap.remove(currentSubString);
                        }
                        if (currentHashMap.size() == 0) {
                            result.add(i);
                            break;
                        }
                    } else {
                        break;
                    }
                    j += wordLenght;

                }

            }

        }
        return result;

    }

    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String words[] = { "bar", "foo", "the" };
        System.out.println(findIndex(s, words));
    }

}
