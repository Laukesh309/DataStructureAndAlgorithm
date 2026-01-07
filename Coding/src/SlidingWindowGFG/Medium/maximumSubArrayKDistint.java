package SlidingWindowGFG.Medium;

import java.util.HashMap;

public class maximumSubArrayKDistint {

    public static int findMax(String s, int k) {
        int left = 0;
        int maxFrequency = Integer.MIN_VALUE;
        int maxLength = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            hm.put(curChar, hm.getOrDefault(curChar, 0) + 1);
            maxFrequency = Math.max(maxFrequency, hm.get(curChar));
            int totalElement = i - left + 1;
            if (totalElement - maxFrequency > k) {
                hm.put(s.charAt(left), hm.get(s.charAt(left)) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "ADBD";
        int k = 1;
        System.out.println(findMax(s, k));
    }

}
