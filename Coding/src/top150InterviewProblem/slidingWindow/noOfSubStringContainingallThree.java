package top150InterviewProblem.slidingWindow;

import java.util.HashMap;

public class noOfSubStringContainingallThree {

    public static int findNoOfSubString(String str) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Character, Integer> hs = new HashMap<>();
        while (right < str.length()) {
            char currentChar = str.charAt(right);
            hs.put(currentChar, hs.getOrDefault(currentChar, 0) + 1);
            while (hs.size() >= 3) {
                max = max + str.length() - right;
                hs.put(str.charAt(left), hs.get(str.charAt(left)) - 1);
                if (hs.get(str.charAt(left)) == 0) {
                    hs.remove(str.charAt(left));
                }
                left++;
            }
            right++;

        }
        return max;
    }

    public static void main(String[] args) {
        String str = "abcabc";
        System.out.println(findNoOfSubString(str));
    }

}
