package Sheet.String.Medium;

import java.util.HashMap;

public class LongestRepeatingCharacter {

    public static int findLongestSubString(String str, int k) {
        int leftMax = 0;
        int left = 0;
        while (left < str.length()) {
            int right = left;
            int counter = 0;
            while (right < str.length() && (str.charAt(left) == str.charAt(right) || counter < k)) {
                if (str.charAt(left) != str.charAt(right)) {
                    counter++;
                }
                right++;

            }
            System.out.println(right + " " + left);
            leftMax = Math.max(leftMax, right - left);
            left++;
        }
    }

    public static void main(String[] args) {
        String str = "AABABBA";
        int k = 1;
        System.out.println(findLongestSubString(str, k));

    }
}
