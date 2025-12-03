package top150InterviewProblem.DPTwoDimenstion;

public class interleavingSubString {

    public static boolean checkFormedOrNode(String s1, String s2, String s3, int firstIndex, int secondIndex,
            int thirdIndex) {
        if (thirdIndex >= s3.length()) {
            return true;
        }
        if (firstIndex < s1.length() && secondIndex < s2.length() && s1.charAt(firstIndex) == s3.charAt(thirdIndex)
                && s2.charAt(secondIndex) == s3.charAt(thirdIndex)) {
            return checkFormedOrNode(s1, s2, s3, firstIndex + 1, secondIndex, thirdIndex + 1)
                    || checkFormedOrNode(s1, s2, s3, firstIndex, secondIndex + 1, thirdIndex + 1);
        }
        if (firstIndex < s1.length() && s1.charAt(firstIndex) == s3.charAt(thirdIndex)) {
            return checkFormedOrNode(s1, s2, s3, firstIndex + 1, secondIndex, thirdIndex + 1);
        }
        if (secondIndex < s2.length() && s2.charAt(secondIndex) == s3.charAt(thirdIndex)) {
            return checkFormedOrNode(s1, s2, s3, firstIndex, secondIndex + 1, thirdIndex + 1);
        }
        return false;
    }

    public static boolean findInterleaving(String s1, String s2, String s3) {
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
                    }
                } else if (j == 0) {
                    if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                        dp[i][j] = dp[i - 1][j];
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
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(checkFormedOrNode(s1, s2, s3, 0, 0, 0));
        System.out.println(findInterleaving(s1, s2, s3));

    }

}
