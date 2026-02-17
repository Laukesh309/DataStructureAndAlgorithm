package GFGDynamicProgrammin;

import java.util.HashSet;

public class NoOfPelindromicSubsequence {

    public static void findTotalPelindricLength(String s) {
        int suffix[] = new int[26];
        int prefix[] = new int[26];
        for (int i = s.length() - 1; i >= 0; i--) {
            int index = s.charAt(i) - 'a';
            suffix[index]++;
        }
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int currentIndex = s.charAt(i) - 'a';
            suffix[currentIndex]--;
            char currentChar = s.charAt(i);
            for (int row = 0; row < 26; row++) {
                if (prefix[row] != 0 && suffix[row] != 0) {
                    char first = (char) (row + 'a');

                    result.add(first + "" + currentChar + "" + first);
                }
            }
            prefix[currentIndex]++;
        }
        return result.size();
    }

    public static void main(String[] args) {
        String s = "bbcbaba";
        findTotalPelindricLength(s);
    }

}
