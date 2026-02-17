package GFGDynamicProgrammin;

public class PalindromicPartitionSecond {

    public static boolean checkPalindrom(String s, int start, int endIndex) {
        while (start <= endIndex) {
            if (s.charAt(start++) != s.charAt(endIndex--)) {
                return false;
            }
        }
        return true;
    }

    public static int findMinCut(String s, int startIndex, int endIndex, int dp[][]) {
        if (checkPalindrom(s, startIndex, endIndex)) {
            return 0;
        }

        if (dp[startIndex][endIndex] != -1) {
            return dp[startIndex][endIndex];
        }
        int totalCut = Integer.MAX_VALUE;
        for (int i = startIndex; i < endIndex; i++) {
            int leftCut = findMinCut(s, startIndex, i, dp);
            int rightCut = findMinCut(s, i + 1, endIndex, dp);
            totalCut = Math.min(totalCut, 1 + leftCut + rightCut);
        }
        dp[startIndex][endIndex] = totalCut;
        return dp[startIndex][endIndex];
    }

    public static void findTempArray(boolean result[][]) {
        for (boolean[] is : result) {
            for (boolean item : is) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

    }

    public static int findMinParitition(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int row = 0; row < s.length(); row++) {
            for (int col = 0; col < s.length(); col++) {
                if (row >= col) {
                    dp[row][col] = true;
                }
            }
        }
        findTempArray(dp);
        for (int row = s.length() - 2; row >= 0; row--) {
            for (int col = row + 1; col < s.length(); col++) {
                if (s.charAt(row) == s.charAt(col)) {
                    dp[row][col] = dp[row + 1][col - 1];
                } else {
                    dp[row][col] = false;
                }
            }
        }

        int result[] = new int[s.length() + 1];
        for (int i = 2; i <= s.length(); i++) {
            if (dp[0][i - 1] == true) {
                result[i] = 0;
            } else {
                int total = Integer.MAX_VALUE;
                for (int k = i - 2; k >= 0; k--) {
                    if (dp[k + 1][i - 1]) {
                        total = Math.min(total, 1 + result[k + 1]);
                    }
                }
                result[i] = total;
            }
        }
        // findTempArray(result);
        return result[s.length()];

    }

    public static void main(String[] args) {
        String s = "aab";
        // int dp[][] = new int[s.length()][s.length()];
        // for (int i = 0; i < s.length(); i++) {
        // for (int j = 0; j < s.length(); j++) {
        // dp[i][j] = -1;
        // }
        // }
        // System.out.println(findMinCut(s, 0, s.length() - 1, dp));
        System.out.println(findMinParitition(s));
    }

}
