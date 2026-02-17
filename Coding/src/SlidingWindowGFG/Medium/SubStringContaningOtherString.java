package SlidingWindowGFG.Medium;

public class SubStringContaningOtherString {

    public static boolean checkValidString(int sArray[], int pArray[]) {

        for (int i = 0; i < 26; i++) {
            if (sArray[i] < pArray[i]) {
                return false;
            }
        }
        return true;

    }

    public static String minSubString(String s, String p) {
        int pLength = p.length();
        int pArray[] = new int[26];
        int sArray[] = new int[26];
        int maxLength = Integer.MAX_VALUE;
        int left = 0;
        String result = "";
        for (int i = 0; i < p.length(); i++) {
            pArray[p.charAt(i) - 'a']++;
            sArray[s.charAt(i) - 'a']++;
        }
        if (checkValidString(sArray, pArray)) {
            result = s.substring(left, p.length());
            return result;
        }
        for (int i = pLength; i < s.length(); i++) {
            char curChar = s.charAt(i);
            sArray[curChar - 'a']++;
            while (checkValidString(sArray, pArray)) {
                if (maxLength > i - left + 1) {
                    maxLength = i - left + 1;
                    result = s.substring(left, i + 1);
                }
                sArray[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        String s = "timetopractice", p = "toc";
        System.out.println(minSubString(s, p));
    }

}
