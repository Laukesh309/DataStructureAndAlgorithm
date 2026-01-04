package SlidingWindowGFG.Easy;

import java.util.HashMap;

public class permutationString {

    public static boolean checkPermutation(int patFequency[], int resultFrequency[]) {
        for (int i = 0; i < 26; i++) {
            if (patFequency[i] != resultFrequency[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPermutation(String txt, String pat) {
        int m = pat.length();
        int patFequency[] = new int[26];
        int resultFrequency[] = new int[26];
        for (int i = 0; i < pat.length(); i++) {
            patFequency[pat.charAt(i) - 'a']++;
            resultFrequency[txt.charAt(i) - 'a']++;
        }
        if (checkPermutation(patFequency, resultFrequency)) {
            return true;
        }
        for (int i = m; i < txt.length(); i++) {
            resultFrequency[txt.charAt(i) - 'a']++;
            resultFrequency[txt.charAt(i - m) - 'a']--;
            if (checkPermutation(patFequency, resultFrequency)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String txt = "programming";
        String pat = "rain";
        System.out.println(isPermutation(txt, pat));

    }

}
