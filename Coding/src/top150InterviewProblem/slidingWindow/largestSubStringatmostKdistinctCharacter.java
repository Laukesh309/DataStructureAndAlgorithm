package top150InterviewProblem.slidingWindow;

import java.util.HashMap;

public class largestSubStringatmostKdistinctCharacter {

    public static int findMaxDistinctWindow(String str, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Character, Integer> hs = new HashMap<>();
        while (right < str.length()) {
            char currentChar = str.charAt(right);
            hs.put(currentChar, hs.getOrDefault(currentChar, 0) + 1);
            if (hs.size() <= k) {
                max = Math.max(max, right - left + 1);
            } else {
                char leftChar = str.charAt(left);
                hs.put(leftChar, hs.get(leftChar) - 1);
                left++;
            }
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "aaabbccd";
        int k = 2;
        System.out.println(findMaxDistinctWindow(str, k));
    }

}
