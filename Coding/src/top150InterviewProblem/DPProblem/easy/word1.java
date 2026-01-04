package top150InterviewProblem.DPProblem.easy;

import java.util.ArrayList;
import java.util.List;

public class word1 {

    public static void findData(boolean dp[]) {
        for (boolean b : dp) {
            System.out.print(b + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            String temp = "";
            for (int j = i; j >= 0; j--) {
                temp = s.charAt(j) + temp;
                System.out.println(temp);
                if (set.contains(temp) && dp[j]) {
                    dp[i + 1] = true;
                    break;
                }

            }
        }
        findData(dp);

    }

}
