package top150InterviewProblem.DPProblem.medium;

public class interleavingSubStirng {

    public static boolean checkSubString(String s1, String s2, String s3, int firstIndex, int secondIndex,
            int thirdIndex) {
        if (thirdIndex >= s3.length()) {
            return true;
        }
        System.out.println(firstIndex + " " + secondIndex + " " + thirdIndex);
        if (firstIndex < s1.length() && s1.charAt(firstIndex) != s3.charAt(thirdIndex)
                && secondIndex < s2.length() && s2.charAt(secondIndex) != s3.charAt(thirdIndex)) {
            return false;
        }
        boolean firstTake = false;
        boolean secondTake = false;
        if (firstIndex < s1.length() && s1.charAt(firstIndex) == s3.charAt(thirdIndex)
                && secondIndex < s2.length() && s2.charAt(secondIndex) == s3.charAt(thirdIndex)) {
            firstTake = checkSubString(s1, s2, s3, firstIndex + 1, secondIndex, thirdIndex + 1);
            secondTake = checkSubString(s1, s2, s3, firstIndex, secondIndex + 1, thirdIndex + 1);
            return firstTake || secondTake;
        }
        if (firstIndex < s1.length() && s1.charAt(firstIndex) == s3.charAt(thirdIndex)) {
            return checkSubString(s1, s2, s3, firstIndex + 1, secondIndex, thirdIndex + 1);
        }
        if (secondIndex < s2.length() && s2.charAt(secondIndex) == s3.charAt(thirdIndex)) {
            return checkSubString(s1, s2, s3, firstIndex, secondIndex + 1, thirdIndex + 1);
        }
        return false;
    }

    public static boolean findSubString(String s1, String s2, String s3) {
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = true;

                } else if (i == 0) {
                    if (s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1]) {
                        dp[0][j] = true;
                    }
                } else if (j == 0) {
                    if (s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0]) {
                        dp[i][0] = true;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        for (int row = 1; row <= s1.length(); row++) {
            for (int col = 1; col <= s2.length(); col++) {
                int lastStringIndex = row + col - 1;
                if (s1.charAt(row - 1) == s3.charAt(lastStringIndex)
                        && s2.charAt(col - 1) == s3.charAt(lastStringIndex)) {
                    dp[row][col] = dp[row - 1][col] || dp[row][col - 1];
                } else if (s1.charAt(row - 1) == s3.charAt(lastStringIndex)) {
                    dp[row][col] = dp[row - 1][col];
                } else if (s2.charAt(col - 1) == s3.charAt(lastStringIndex)) {
                    dp[row][col] = dp[row][col - 1];
                } else {
                    dp[row][col] = false;
                }
            }
        }
        return dp[s1.length()][s2.length()];

    }

    public static void findTemp(boolean dp[][]) {
        for (boolean[] bs : dp) {

            for (boolean item : bs) {
                System.out.print(item + " ");

            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        // if (s1.length() + s2.length() < s2.length()) {
        // return false;
        // }
        // System.out.println("laukesh");
        // System.out.println(checkSubString(s1, s2, s3, 0, 0, 0));
        System.out.println(findSubString(s1, s2, s3));

    }

}
