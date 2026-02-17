package GFGDynamicProgrammin;

public class countPalindromicSubsequenceSecond {

    public static int findAllPalindrome(String s, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return 1;
        }
        if (startIndex > endIndex) {
            return 0;
        }
        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            return 2 * findAllPalindrome(s, startIndex, endIndex - 1) + 1;
        } else {
            return findAllPalindrome(s, startIndex + 1, endIndex) + findAllPalindrome(s, startIndex, endIndex - 1)
                    - findAllPalindrome(s, startIndex + 1, endIndex - 1);
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(findAllPalindrome(s, 0, s.length() - 1));
    }

}
