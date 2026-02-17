package GFGDynamicProgrammin;

import java.util.HashSet;
import java.util.Set;

public class wordBreak {

    public static boolean wordBreak(String s, int end, Set<String> st, Boolean dp[]) {
        if (end < 0) {
            return true;
        }
        if (dp[end] != null) {
            return true;
        }
        for (int i = end; i >= 0; i--) {
            String subString = s.substring(i, end + 1);
            if (st.contains(subString)) {
                if (wordBreak(s, i - 1, st, dp)) {
                    dp[end] = true;
                    return true;
                }
            }
        }
        dp[end] = false;

        return false;
    }

    public static boolean findWordBreak(String s, Set<String> st) {
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j >= 0; j--) {
                if (dp[j] && st.contains(s.substring(j, i))) {
                    dp[i] = true;
                }

            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "ilikemangoes";
        String[] dictionary = { "i", "like", "man", "india", "gfg" };
        Boolean dp[] = new Boolean[s.length()];
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < dictionary.length; i++) {
            hs.add(dictionary[i]);
        }
        System.out.println(wordBreak(s, s.length() - 1, hs, dp));
        System.out.println(findWordBreak(s, hs));

    }
}
