package top150InterviewProblem.DPProblem.medium;

import top150InterviewProblem.DPProblem.easy.stair;

public class interleavingSubString {

    public static boolean isItformed(String s1, String s2, String s3, int firstIndex, int secondIndex, int thirdIndex) {
        if (thirdIndex >= s3.length()) {
            if (firstIndex < s1.length() || secondIndex < s2.length()) {
                return false;
            }
            return true;
        }

        if (firstIndex < s1.length() && secondIndex < s2.length() && s1.charAt(firstIndex) == s3.charAt(thirdIndex)
                && s2.charAt(secondIndex) == s3.charAt(thirdIndex)) {
            return isItformed(s1, s2, s3, firstIndex + 1, secondIndex,
                    thirdIndex + 1)
                    || isItformed(s1, s2, s3, firstIndex, secondIndex + 1, thirdIndex + 1);
        }
        if (firstIndex < s1.length() && s1.charAt(firstIndex) == s3.charAt(thirdIndex)) {
            return isItformed(s1, s2, s3, firstIndex + 1, secondIndex,
                    thirdIndex + 1);
        }
        if (secondIndex < s2.length() && s2.charAt(secondIndex) == s3.charAt(thirdIndex)) {
            return isItformed(s1, s2, s3, firstIndex, secondIndex + 1,
                    thirdIndex + 1);
        }
        return false;

    }

    public static boolean isItformedDynamic(String s1, String s2, String s3, int firstIndex, int secondIndex,
            int thirdIndex, boolean dp[][][]) {
        if (thirdIndex >= s3.length()) {
            if (firstIndex < s1.length() || secondIndex < s2.length()) {
                return false;
            }
            return true;
        }

        if (firstIndex < s1.length() && secondIndex < s2.length() && s1.charAt(firstIndex) == s3.charAt(thirdIndex)
                && s2.charAt(secondIndex) == s3.charAt(thirdIndex)) {
            dp[firstIndex][secondIndex][thirdIndex] = isItformed(s1, s2, s3, firstIndex + 1, secondIndex,
                    thirdIndex + 1)
                    || isItformed(s1, s2, s3, firstIndex, secondIndex + 1, thirdIndex + 1);
        } else if (firstIndex < s1.length() && s1.charAt(firstIndex) == s3.charAt(thirdIndex)) {
            dp[firstIndex][secondIndex][thirdIndex] = isItformed(s1, s2, s3, firstIndex + 1, secondIndex,
                    thirdIndex + 1);
        } else if (secondIndex < s2.length() && s2.charAt(secondIndex) == s3.charAt(thirdIndex)) {
            dp[firstIndex][secondIndex][thirdIndex] = isItformed(s1, s2, s3, firstIndex, secondIndex + 1,
                    thirdIndex + 1);
        } else {
            dp[firstIndex][secondIndex][thirdIndex] = false;
        }
        return dp[firstIndex][secondIndex][thirdIndex];

    }

    public static boolean findValueFromLast(String s1, String s2, String s3, int firstIndex, int secondIndex,
            int thirdIndex) {
        if (thirdIndex < 0) {
            if (firstIndex < 0 && secondIndex < 0) {
                return true;
            }
            return false;
        }
        if (firstIndex >= 0 && secondIndex >= 0 && s1.charAt(firstIndex) == s3.charAt(thirdIndex)
                && s2.charAt(secondIndex) == s3.charAt(thirdIndex)) {
            return findValueFromLast(s1, s2, s3, firstIndex - 1, secondIndex, thirdIndex - 1)
                    || findValueFromLast(s1, s2, s3, firstIndex, secondIndex - 1, thirdIndex - 1);
        }
        if (secondIndex >= 0 && s2.charAt(secondIndex) == s3.charAt(thirdIndex)) {
            return findValueFromLast(s1, s2, s3, firstIndex, secondIndex - 1, thirdIndex - 1);
        }
        if (firstIndex >= 0 && s1.charAt(firstIndex) == s3.charAt(thirdIndex)) {
            return findValueFromLast(s1, s2, s3, firstIndex - 1, secondIndex, thirdIndex - 1);
        }
        return false;

    }

    public static void printArray(boolean dp[][][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    System.out.print(i + " " + j + " " + k + " " + dp[i][j][k] + " ");
                }
                System.out.println();
            }
        }
    }

    public static boolean findDynmic(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    if (s2.charAt(j - 1) == s3.charAt(j - 1)) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                } else if (j == 0) {
                    if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "aabc";
        String s2 = "abad";
        String s3 = "aabcabad";
        // String s1 = "aabcc";
        // String s2 = "dbbca";
        // String s3 = "aadbbcbcac";
        boolean dp[][][] = new boolean[s1.length() + 1][s2.length() + 1][s3.length()];
        System.out.println(isItformed(s1, s2, s3, 0, 0, 0));
        // System.out.println(findValueFromLast(s1, s2, s3, s1.length() - 1,
        // s2.length());
        System.out.println(isItformedDynamic(s1, s2, s3, 0, 0, 0, dp));
        System.out.println(findDynmic(s1, s2, s3));
        // - 1, s3.length() - 1));
        // printArray(dp);

    }

}
