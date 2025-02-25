package top150InterviewProblem.slidingWindowRevision;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStringWithOutRepeating {

    public int lengthOfLongestSubstring(String str) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Character, Integer> hs = new HashMap<>();
        while (right < str.length()) {
            if (hs.containsKey(str.charAt(right)) && hs.get(str.charAt(right)) >= left) {
                left = hs.get(str.charAt(right)) + 1;
            }
            hs.put(str.charAt(right), right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int left = 0;
        int max = Integer.MIN_VALUE;
        HashSet<Character> hs = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            if (!hs.contains(s.charAt(right))) {
                max = Math.max(max, right - left + 1);
            } else {
                while (hs.contains(s.charAt(right))) {
                    hs.remove(s.charAt(left++));
                }

            }
            hs.add(s.charAt(right));
        }
        return max;
    }

}
