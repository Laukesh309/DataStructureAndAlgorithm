package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class houseRobber2 {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                String temp = s.substring(j, i);
                if (wordDict.contains(temp) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
    }

}
