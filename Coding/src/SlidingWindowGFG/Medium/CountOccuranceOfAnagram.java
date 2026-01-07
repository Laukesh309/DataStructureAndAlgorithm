package SlidingWindowGFG.Medium;

public class CountOccuranceOfAnagram {

    public static boolean checkIsAnagram(int txtArray[], int patArray[]) {
        for (int i = 0; i < 26; i++) {
            if (txtArray[i] != patArray[i]) {
                return false;
            }
        }
        return true;
    }

    public static int findTotalAnagram(String txt, String pat) {
        int txtLength = txt.length();
        int patLength = pat.length();
        int totalCount = 0;
        if (patLength > txtLength) {
            return -1;
        }
        int left = 0;
        int txtArray[] = new int[26];
        int patArray[] = new int[26];
        for (int i = 0; i < patLength; i++) {
            txtArray[txt.charAt(i) - 'a']++;
            patArray[pat.charAt(i) - 'a']++;
        }
        if (checkIsAnagram(txtArray, patArray)) {
            totalCount = 1;
        }
        for (int i = patLength; i < txtLength; i++) {
            txtArray[txt.charAt(left++) - 'a']--;
            txtArray[txt.charAt(i) - 'a']++;
            if (checkIsAnagram(txtArray, patArray)) {
                totalCount = totalCount + 1;
            }
        }
        return totalCount;
    }

    public static void main(String[] args) {
        String txt = "aabaabaa", pat = "aaba";
        System.out.println(findTotalAnagram(txt, pat));
    }

}
