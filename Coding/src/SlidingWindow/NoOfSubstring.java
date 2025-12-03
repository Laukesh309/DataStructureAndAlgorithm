package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class NoOfSubstring {

    public static void main(String[] args) {
        String s = "abcabc";
        int left = 0;
        int right = 0;
        int count = 0;
        int total = 0;
        int totaLength = s.length();
        int tempResult[] = new int[3];
        while (right < s.length()) {
            while (right < s.length() && count < 3) {
                if (tempResult[s.charAt(right) - 'a'] == 0) {
                    count++;
                }
                tempResult[s.charAt(right) - 'a']++;
                right++;
            }
            while (count == 3) {
                char leftChar = s.charAt(left);
                tempResult[leftChar - 'a']--;
                total = total + totaLength - right + 1;
                if (tempResult[leftChar - 'a'] == 0) {
                    count--;
                }
                left++;
            }

        }
        System.out.println(total);
    }
}
