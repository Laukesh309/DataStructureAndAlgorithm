package top150InterviewProblem.slidingWindow;

import java.util.HashMap;

public class LongestCommonSubString {

    public static int findMaxSum(String str) {
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
        String str = "abba";
        System.out.println(findMaxSum(str));
    }

}
