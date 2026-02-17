package GFGDynamicProgrammin;

import java.util.Arrays;

public class PalindromicSubSequenceThird {

    public static int findTotalDisjointSet(String s, int k) {
        boolean palidromic[][] = new boolean[s.length()][s.length()];
        for (int row = 0; row < s.length(); row++) {
            for (int col = 0; col <= row; col++) {
                palidromic[row][col] = true;
            }
        }
        for (int row = s.length() - 2; row >= 0; row--) {
            for (int col = row + 1; col < s.length(); col++) {
                if (s.charAt(row) == s.charAt(col)) {
                    palidromic[row][col] = palidromic[row + 1][col - 1];
                } else {
                    palidromic[row][col] = false;
                }
            }
        }
        int result[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {

            if (palidromic[0][i] == true) {
                result[i] = 0;
            } else {
                int total = Integer.MAX_VALUE;
                for (int t = i - 1; t >= 0; t--) {
                    if (palidromic[t + 1][i] == true) {
                        total = Math.min(total, 1 + result[t]);
                    }
                }
                result[i] = total;
            }

        }
        int totalDisjointSet = result[s.length() - 1] + 1;
        if (totalDisjointSet < k) {
            return 0;
        } else {
            return totalDisjointSet - k;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        int k = 2;
        findTotalDisjointSet(s, k);

    }

}
