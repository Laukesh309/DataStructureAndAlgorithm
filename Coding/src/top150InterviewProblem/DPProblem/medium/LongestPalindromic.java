package top150InterviewProblem.DPProblem.medium;

public class LongestPalindromic {

    public static int findLangest(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                if (i >= j) {
                    dp[i][j] = true;
                }
            }
        }
        String result = s.charAt(0) + "";
        for (int row = s.length() - 1; row >= 0; row--) {
            for (int column = row + 1; column < s.length(); column++) {
                char leftChar = s.charAt(row);
                char rightChar = s.charAt(column);

                if (leftChar == rightChar && dp[row + 1][column - 1]) {
                    max = Math.max(max, column - row + 1);

                    if (max > result.length()) {
                        result = s.substring(row, column + 1);
                    }

                    dp[row][column] = true;
                }
            }
        }
        System.out.println(result);
        System.out.println(max);
        return 0;
    }

    public static void printDp(boolean dp[][]) {
        for (boolean[] bs : dp) {
            for (boolean item : bs) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String s = "cbbd";
        findLangest(s);
    }

}
