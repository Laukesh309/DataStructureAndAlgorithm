package SlidingWindowGFG.Medium;

public class kWindow {

    public static int findTotalSubArray(String s, int k) {

        int charArray[] = new int[26];
        int totalDistinct = 0;
        for (int i = 0; i < k; i++) {
            char curChar = s.charAt(i);
            if (charArray[curChar - 'a'] == 0) {
                totalDistinct++;
            }
            charArray[curChar - 'a']++;
        }
        int result = 0;
        if (totalDistinct == k - 1) {
            result = 1;
        }
        for (int i = k; i < s.length(); i++) {
            char curChar = s.charAt(i);
            charArray[curChar - 'a']++;
            if (charArray[curChar - 'a'] == 1) {
                totalDistinct++;
            }
            charArray[s.charAt(i - k) - 'a']--;
            if (charArray[s.charAt(i - k) - 'a'] == 0) {
                totalDistinct--;
            }
            if (totalDistinct == k - 1) {
                result = result + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aabab";
        int k = 3;
        System.out.println(findTotalSubArray(s, k));
    }

}
