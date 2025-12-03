package top150InterviewProblem.DPOneDimansion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordBreak {

    public static void printArray(boolean str[]) {
        for (boolean string : str) {
            System.out.print(string + " ");
        }
    }

    public static boolean isFormed(List<String> wordDict, String str, int max) {
        boolean dp[] = new boolean[str.length() + 1];
        dp[str.length()] = true;
        for (int i = str.length() - 1; i >= 0; i--) {
            String tempString = "";
            for (int j = i; j < str.length(); j++) {
                tempString = tempString + str.charAt(j);
                if (wordDict.contains(tempString)) {
                    dp[i] = dp[i] || dp[j + 1];
                }

            }
        }
        printArray(dp);

        return false;

    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("cat");
        wordDict.add("and");
        isFormed(wordDict, s, 0);
    }

}
