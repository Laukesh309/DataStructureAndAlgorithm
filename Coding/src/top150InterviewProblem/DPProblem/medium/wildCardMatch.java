package top150InterviewProblem.DPProblem.medium;

public class wildCardMatch {

    public static boolean findWildCard(String str, String ptr, int left, int right) {
        if (left < 0 && right < 0) {
            return true;
        }
        if (right < 0) {
            return false;
        }
        if (left < 0) {
            if (ptr.charAt(right) == '*') {
                return findWildCard(str, ptr, left, right - 1);
            } else {
                return false;
            }

        }
        if (ptr.charAt(right) == '?' || ptr.charAt(right) == str.charAt(left)) {
            return findWildCard(str, ptr, left - 1, right - 1);
        }
        if (ptr.charAt(right) == '*') {
            return findWildCard(str, ptr, left, right - 1) || findWildCard(str, ptr, left - 1, right - 1)
                    || findWildCard(str, ptr, left - 1, right);
        }
        return false;

    }

    public static boolean findWildDynamic(String str, String ptr) {
        boolean dp[][] = new boolean[str.length() + 1][ptr.length() + 1];
        for (int i = 0; i <= str.length(); i++) {
            for (int j = 0; j <= ptr.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0 && ptr.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        for (int row = 1; row <= str.length(); row++) {
            for (int column = 1; column <= ptr.length(); column++) {
                if (ptr.charAt(column) == '?') {
                    dp[row][column] = dp[row - 1][column - 1];
                } else if (ptr.charAt(column) == '*') {
                    dp[row][column] = dp[row - 1][column] || dp[row - 1][column - 1] || dp[row][column - 1];
                } else {
                    if (str.charAt(row) == ptr.charAt(column)) {
                        dp[row][column] = dp[row - 1][column - 1];
                    } else {
                        dp[row][column] = false;
                    }
                }
            }
        }
        return dp[str.length()][ptr.length()];
    }

    public static void main(String[] args) {
        String str = "";
        String ptr = "?";
        System.out.println(findWildCard(str, ptr, str.length() - 1, ptr.length() - 1));
        System.out.println(findWildDynamic(str, ptr));
    }

}
