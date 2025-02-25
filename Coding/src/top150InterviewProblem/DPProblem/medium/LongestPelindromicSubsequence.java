package top150InterviewProblem.DPProblem.medium;

public class LongestPelindromicSubsequence {

    public static boolean findPelindrome(String str) {
        int firstIndex = 0;
        int lastIndex = str.length() - 1;
        while (firstIndex <= lastIndex) {
            if (str.charAt(firstIndex) != str.charAt(lastIndex)) {
                return false;
            }
            firstIndex++;
            lastIndex--;

        }
        return true;
    }

    public static int findMax(String str, int currentIndex, String result) {
        if (currentIndex >= str.length()) {
            if (findPelindrome(result)) {
                return result.length();
            } else {
                return 0;
            }
        }
        int take = findMax(str, currentIndex + 1, result + str.charAt(currentIndex));
        int nonTake = findMax(str, currentIndex + 1, result);
        return Math.max(take, nonTake);
    }

    public static int findMaxSecondDynamic(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        dp[0][0] = 0;
        for (int row = 1; row <= str1.length(); row++) {
            for (int column = 1; column <= str2.length(); column++) {
                if (str1.charAt(row - 1) == str2.charAt(column - 1)) {
                    dp[row][column] = 1 + dp[row - 1][column - 1];
                } else {
                    dp[row][column] = Math.max(dp[row - 1][column], dp[row][column - 1]);
                }
            }
        }

        return dp[str1.length()][str2.length()];

    }

    public static void main(String[] args) {
        String str = "bbbab";
        StringBuffer sfg = new StringBuffer(str);
        sfg.reverse();
        String str2 = sfg.toString();
        System.out.println(str2);
        // System.out.println(findMax(str, 0, ""));s
        System.out.println(findMaxSecondDynamic(str, str2));

    }

}
