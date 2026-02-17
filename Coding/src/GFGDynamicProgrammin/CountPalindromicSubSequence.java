package GFGDynamicProgrammin;

public class CountPalindromicSubSequence {

    public static boolean checkPalindrome(String s) {
        int firstIndex = 0;
        int secondIndex = s.length() - 1;
        while (firstIndex <= secondIndex) {
            if (s.charAt(firstIndex) != s.charAt(secondIndex)) {
                return false;
            }
            firstIndex++;
            secondIndex--;
        }
        return true;
    }

    public static int totalSubSequce(String s, int currentIndex, String result) {
        if (result.length() == 5) {
            if (checkPalindrome(result)) {
                return 1;
            }
            return 0;
        }
        if (currentIndex >= s.length()) {
            return 0;
        }
        if (result.length() > 5) {
            return 0;
        }

        int include = totalSubSequce(s, currentIndex + 1, result + s.charAt(currentIndex));
        int exclude = totalSubSequce(s, currentIndex + 1, result);
        return include + exclude;

    }

    public static int findTotalPalindrome(String s, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return 1;
        }
        int leftInclude = findTotalPalindrome(s, startIndex + 1, endIndex);
        int rightInclude = findTotalPalindrome(s, startIndex, endIndex - 1);
        int bothExclude = 0;
        if (s.charAt(startIndex) == s.charAt(endIndex)) {
            bothExclude = findTotalPalindrome(s, startIndex + 1, endIndex - 1);
        }
        return leftInclude + rightInclude + bothExclude;
    }

    public static void main(String[] args) {
        String s = "103301";
        int dp[][][] = new int[s.length()][][]
        System.out.println(totalSubSequce(s, 0, ""));
    }

}
