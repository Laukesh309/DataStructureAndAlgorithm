package SlidingWindow;

import java.util.HashMap;

public class LongestReapeatingChar {

    public static void main(String[] args) {
        String s = "ABBA";
        int k = 2;
        int left = 0;
        int right = 0;
        int totalSubString = 0;
        int maxFrequece = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        while (right < s.length()) {
            char currChar = s.charAt(right);
            hm.put(currChar, hm.getOrDefault(currChar, 0) + 1);
        }
        System.out.println(totalSubString);

    }

}
