// https://leetcode.com/problems/minimum-window-substring/submissions/1545057715/

package top150InterviewProblem.slidingWindowRevision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class minimumWindowSubString {
    public static boolean isTrue(HashMap<Character, Integer> hs, HashMap<Character, Integer> ts) {
        if (hs.size() != ts.size() || !hs.keySet().equals(ts.keySet())) {
            return false;
        }
        Set<Character> st = hs.keySet();
        for (Character character : st) {
            if (hs.get(character) < ts.get(character)) {
                return false;
            }
        }
        return true;
    }

    public static String findMin(String s, String t) {
        HashMap<Character, Integer> hs = new HashMap<>();
        HashMap<Character, Integer> ts = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            ts.put(currentChar, ts.getOrDefault(currentChar, 0) + 1);
        }

        int left = 0;
        int right = 0;
        String result = "";
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (ts.containsKey(currentChar)) {
                hs.put(currentChar, hs.getOrDefault(currentChar, 0) + 1);

            }
            while (isTrue(hs, ts)) {
                if (result.length() == 0) {
                    result = s.substring(left, right + 1);
                } else {
                    if (result.length() > s.substring(left, right + 1).length()) {
                        result = s.substring(left, right + 1);
                    }
                }
                char leftChar = s.charAt(left);
                if (hs.containsKey(leftChar)) {
                    hs.put(leftChar, hs.get(leftChar) - 1);
                    if (hs.get(leftChar) == 0) {
                        hs.remove(leftChar);
                    }
                }
                left++;

            }
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";
        System.out.println(findMin(s, t));
    }

}
