package GFGDynamicProgrammin;

public class InterLeavedString {

    public static boolean findInterleavedString(String s1, String s2, String s3, int firstIndex, int secondIndex,
            int thirdIndex) {
        if (thirdIndex < 0) {
            return true;
        }
        if (firstIndex >= 0 && secondIndex >= 0 && s1.charAt(firstIndex) != s3.charAt(thirdIndex)
                && s2.charAt(secondIndex) != s3.charAt(thirdIndex)) {
            return false;
        }
        if (firstIndex >= 0 && secondIndex >= 0 && s1.charAt(firstIndex) == s3.charAt(thirdIndex)
                && s2.charAt(secondIndex) == s3.charAt(thirdIndex)) {
            return findInterleavedString(s1, s2, s3, firstIndex - 1, secondIndex, thirdIndex - 1)
                    || findInterleavedString(s1, s2, s3, firstIndex, secondIndex - 1, thirdIndex - 1);
        }
        if (firstIndex >= 0 && s1.charAt(firstIndex) == s3.charAt(thirdIndex)) {
            return findInterleavedString(s1, s2, s3, firstIndex - 1, secondIndex, thirdIndex - 1);
        }
        if (secondIndex >= 0 && s2.charAt(secondIndex) == s3.charAt(thirdIndex)) {
            return findInterleavedString(s1, s2, s3, firstIndex, secondIndex - 1, thirdIndex - 1);
        }
        return false;
    }

    public static boolean checkString(String s1, String s2, String s3) {
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        // checking firstRow
        dp[0][0] = true;
        for (int col = 1; col <= s2.length(); col++) {
            if (s2.charAt(col - 1) == s3.charAt(col - 1)) {
                dp[0][col] = dp[0][col - 1];
            }
        }
        // checking FirstCol
        for (int row = 1; row <= s1.length(); row++) {
            if (s1.charAt(row - 1) == s3.charAt(row - 1)) {
                dp[row][0] = dp[row - 1][0];
            }
        }
        for (int row = 1; row <= s1.length(); row++) {
            for (int col = 1; col <= s2.length(); col++) {
                int totalLength = row + col;
                if (s1.charAt(row - 1) == s3.charAt(totalLength - 1)
                        && s2.charAt(col - 1) == s3.charAt(totalLength - 1)) {
                    dp[row][col] = dp[row - 1][col] || dp[row][col - 1];
                } else if (s1.charAt(row - 1) == s3.charAt(totalLength - 1)) {
                    dp[row][col] = dp[row - 1][col];
                } else if (s2.charAt(col - 1) == s3.charAt(totalLength - 1)) {
                    dp[row][col] = dp[row][col - 1];
                } else {
                    dp[row][col] = false;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "AAB";
        String s2 = "AAC";
        String s3 = "AAAABC";
        if (s1.length() + s2.length() != s3.length()) {
            System.out.println(false);
        }
        System.out.println(findInterleavedString(s1, s2, s3, s1.length() - 1, s2.length() - 1, s3.length() - 1));
    }

}
