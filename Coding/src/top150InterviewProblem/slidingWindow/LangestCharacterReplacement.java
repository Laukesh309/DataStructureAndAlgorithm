package top150InterviewProblem.slidingWindow;

import java.util.HashMap;

public class LangestCharacterReplacement {

    public static int findMaximumReplacement(String str, int k) {
        int left = 0;
        int right = 0;
        int maxSize = 0;
        int maxFrequecy = 0;
        HashMap<Character, Integer> hs = new HashMap<>();
        while (right < str.length()) {
            char currentChar = str.charAt(right);
            hs.put(currentChar, hs.getOrDefault(currentChar, 0) + 1);
            maxFrequecy = Math.max(maxFrequecy, hs.get(currentChar));
            int curSubString = right - left + 1 - maxFrequecy;
            if (curSubString <= k) {
                maxSize = Math.max(maxSize, right - left + 1);
            } else {
                hs.put(str.charAt(left), hs.get(str.charAt(left)) - 1);
                maxFrequecy = 0;
                left++;
                System.out.println(hs);
                for (int freq : hs.values()) {
                    maxFrequecy = Math.max(freq, maxFrequecy);

                }
            }
            right++;

        }
        return maxSize;
    }

    public static void main(String[] args) {
        String str = "ABBB";
        int k = 1;
        System.out.println(findMaximumReplacement(str, k));
    }

}
