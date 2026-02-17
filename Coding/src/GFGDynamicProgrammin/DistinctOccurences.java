package GFGDynamicProgrammin;

public class DistinctOccurences {

    public static int findTotalMove(String txt, String pat, int firstIndex, int secondIndex) {
        if (secondIndex < 0) {
            return 1;
        }
        if (firstIndex < 0) {
            return 0;
        }
        int total = findTotalMove(txt, pat, firstIndex - 1, secondIndex);
        if (txt.charAt(firstIndex) == pat.charAt(secondIndex)) {
            total = total + findTotalMove(txt, pat, firstIndex - 1, secondIndex - 1);
        }
        return total;
    }

    public static int findTotalMove(String txt, String pat) {
        int dp[][] = new int[txt.length() + 1][pat.length() + 1];
        for (int row = 0; row < txt.length() + 1; row++) {
            dp[row][0] = 1;
        }
        for (int row = 1; row < txt.length() + 1; row++) {
            for (int col = 1; col < pat.length() + 1; col++) {
                dp[row][col] = dp[row - 1][col];
                if (txt.charAt(row - 1) == pat.charAt(col - 1)) {
                    dp[row][col] = dp[row][col] + dp[row - 1][col - 1];
                }
            }
        }
        return dp[txt.length()][pat.length()];

    }

    public static void main(String[] args) {
        String txt = "abba", pat = "aba";

        System.out.println(findTotalMove(txt, pat, txt.length() - 1, pat.length() - 1));
    }

}
