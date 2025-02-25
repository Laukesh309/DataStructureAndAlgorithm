package top150InterviewProblem.DPProblem.medium;

import java.util.ArrayList;
import java.util.List;

public class wordBreak {

    public static void printDp(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isWordBreak(String str, List<String> word, int currentIndex) {
        boolean dp[][] = new boolean[word.size()][str.length()];
        for (int i = 0; i < word.size(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (i == 0) {
                    dp[i][j] = str.substring(0, j + 1).contains(word.get(i));
                } else if (j == 0) {
                    dp[i][j] = str.substring(0, j + 1).contains(word.get(j)) || dp[i - 1][j];
                }
            }
        }
        for (int i = 1; i < word.size(); i++) {
            for (int j = 1; j < str.length(); j++) {

            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "leetcode";
        String wordDict[] = { "leet", "code" };
        List<String> word = new ArrayList<String>();
        for (String string : wordDict) {
            word.add(string);
        }
        System.out.println(isWordBreak(str, word, 0));
    }
}
