package GFGDynamicProgrammin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class wordBreakTwo {

    public static void printArray(boolean dp[]) {
        for (boolean b : dp) {
            System.out.print(b + " ");
        }
        System.out.println();
    }

    public static void wordBreakTwo(String s, Set<String> dict) {

        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        ArrayList<String> tempResult = new ArrayList<>();
        tempResult.add("");
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = dp[j];
                    tempResult.add(tempResult.get(j - 1) + " " + s.substring(j, i));
                }
            }
        }
        System.out.println(tempResult);
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (int i = s.length() - 2; i >= 1; i--) {
            if (dp[i] == true) {
                ArrayList<String> tempString = new ArrayList<>();
                tempString.add(s.substring(0, i) + " " + s.substring(i));
                result.add(tempString);
            }
        }
        System.out.println(result);

        return;

    }

    public static void findAllElement(String s, Set<String> dict, int currentIndex, String result,
            ArrayList<String> finalResult) {
        if (currentIndex == s.length()) {

            finalResult.add(result);
            return;
        }
        for (int i = currentIndex; i <= s.length(); i++) {
            if (dict.contains(s.substring(currentIndex, i))) {
                findAllElement(s, dict, i, result + " " + s.substring(currentIndex, i), finalResult);
            }
        }
    }

    public static void main(String[] args) {
        String s = "likegfg", dict[] = { "lik", "like", "egfg", "gfg" };
        Set<String> hs = new HashSet<>();
        for (int i = 0; i < dict.length; i++) {
            hs.add(dict[i]);
        }
        // wordBreakTwo(s, hs);
        ArrayList<String> finalResult = new ArrayList<>();
        findAllElement(s, hs, 0, "", finalResult);
        String[] test = new String[finalResult.size()];
        for (int i = 0; i < finalResult.size(); i++) {
            test[i] = finalResult.get(i).trim();
        }
        System.out.println(finalResult);

    }

}
