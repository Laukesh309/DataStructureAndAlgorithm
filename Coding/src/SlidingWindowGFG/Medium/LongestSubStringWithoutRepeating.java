package SlidingWindowGFG.Medium;

public class LongestSubStringWithoutRepeating {

    public static int findMaximum(String s) {
        int maximum = 0;
        int left = 0;
        int charArray[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            charArray[curChar - 'a']++;
            while (charArray[curChar - 'a'] > 1) {
                charArray[s.charAt(left) - 'a']--;
                left++;
            }
            maximum = Math.max(i - left + 1, maximum);
        }
        return maximum;
    }

    public static void main(String[] args) {
        String s = "abcdefabcbb";
        System.out.println(findMaximum(s));
    }

}
