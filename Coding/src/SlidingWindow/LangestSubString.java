package SlidingWindow;

import java.util.HashMap;

public class LangestSubString {

    public static void main(String[] args) {
        String s = "geeksforgeeks";
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (map.containsKey(currentChar)) {
                map.remove(s.charAt(left));
                left++;
            } else {
                int totalSize = right - left + 1;
                max = Math.max(totalSize, max);
                map.put(currentChar, right);
                right++;
            }

        }
        System.out.println(max);
    }

}
