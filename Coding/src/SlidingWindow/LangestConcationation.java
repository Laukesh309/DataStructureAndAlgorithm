package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;

public class LangestConcationation {

    public static void findMax(String s, String words[]) {
        HashMap<String, Integer> wordFrequence = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        int wordSize = words[0].length();
        for (int i = 0; i < words.length; i++) {
            wordFrequence.put(words[i], wordFrequence.getOrDefault(words[i], 0) + 1);
        }
        for (int i = 0; i < wordSize; i++) {
            int left = i;
            int right = i;
            HashMap<String, Integer> clone = new HashMap<>();
            while (right + wordSize <= s.length()) {
                String subString = s.substring(right, right + wordSize);
                right += wordSize;
                System.out.println(right);
                if (wordFrequence.containsKey(subString)) {
                    clone.put(subString, clone.getOrDefault(subString, 0) + 1);
                    System.out.println(subString + " " + clone + " " + right);
                    while (left < right && clone.get(subString) > wordFrequence.get(subString)) {
                        String leftSubString = s.substring(left, left + wordSize);
                        left = left + wordSize;
                        clone.put(leftSubString, clone.get(leftSubString) - 1);
                    }
                    if (clone.equals(wordFrequence)) {
                        String leftSubString = s.substring(left, left + wordSize);
                        result.add(left);
                        left = left + wordSize;
                        clone.put(leftSubString, clone.get(leftSubString) - 1);
                    }
                } else {
                    clone.clear();
                    left = right;
                }

            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String words[] = { "bar", "foo", "the" };

        findMax(s, words);
    }

}
