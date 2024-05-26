package DynamicProgramming;

public class wildCardMatchingR1 {

    public static boolean findMatches(String text, String pattern) {
        if (text.isEmpty() && pattern.isEmpty()) {
            return true;
        }
        if (pattern.isEmpty() && !text.isEmpty()) {
            return false;
        }
        if (pattern.charAt(0) == '?') {
            if (text.isEmpty()) {
                return false;
            } else {
                return findMatches(text.substring(1), pattern.substring(1));
            }
        }
        if (pattern.charAt(0) == '*') {
            if (text.isEmpty()) {
                return findMatches(text, pattern.substring(1));
            }
            boolean multiMatch = findMatches(text.substring(1), pattern);
            boolean singleMatch = findMatches(text.substring(1), pattern.substring(1));
            boolean emptyString = findMatches(text, pattern.substring(1));
            return multiMatch || singleMatch || emptyString;
        }
        if (text.isEmpty()) {
            return false;
        }
        if (text.charAt(0) != pattern.charAt(0)) {
            return false;
        } else {
            return findMatches(text.substring(1), pattern.substring(1));
        }
    }

    public static void printdp(boolean dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean findMatchesTabulisation(String text, String pattern) {
        int row = pattern.length();
        int column = text.length();
        boolean dp[][] = new boolean[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (j == 0) {
                    if (pattern.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (pattern.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (pattern.charAt(i - 1) == '*') {
                    boolean empty = dp[i - 1][j];
                    boolean singleString = dp[i - 1][j - 1];
                    boolean multiString = dp[i][j - 1];
                    dp[i][j] = empty || singleString || multiString;
                } else {
                    if (pattern.charAt(i - 1) != text.charAt(j - 1)) {
                        dp[i][j] = false;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }

            }
        }

        // printdp(dp);
        return dp[row][column];

    }

    public static void main(String[] args) {
        String text = "baaabab";
        String pattern = "*****ba***bab";
        // String text = "baaa";
        // String pattern = "a*ab";
        System.out.println(findMatchesTabulisation(text, pattern));

    }

}
