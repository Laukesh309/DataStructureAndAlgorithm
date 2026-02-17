package GFGDynamicProgrammin;

public class DistictSubSequence {

    public static int findTotalSubSequence(String s, String t, int curIndex, int secondIndex) {
        if (secondIndex < 0) {
            return 1;
        }
        if (curIndex < 0) {
            return 0;
        }
        int exlude = findTotalSubSequence(s, t, curIndex - 1, secondIndex);
        int include = 0;
        if (s.charAt(curIndex) == t.charAt(secondIndex)) {
            include = findTotalSubSequence(s, t, curIndex - 1, secondIndex - 1);
        }
        return exlude + include;
    }

    public static int findTotalSubSequenceDynamic(String s, String t) {

        int dp[][] = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        for (int row = 1; row <= s.length(); row++) {
            for (int col = 1; col <= t.length(); col++) {
                int exlude = dp[row - 1][col];
                int include = 0;
                if (s.charAt(row - 1) == t.charAt(col - 1)) {
                    include = dp[row - 1][col - 1];
                }
                dp[row][col] = include + exlude;
            }
        }
        System.out.println(dp[s.length()][t.length()]);
        return dp[s.length()][t.length()];

    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        System.out.println(findTotalSubSequence(s, t, s.length() - 1, t.length() - 1));
        System.out.println(findTotalSubSequenceDynamic(s, t));
    }

}
