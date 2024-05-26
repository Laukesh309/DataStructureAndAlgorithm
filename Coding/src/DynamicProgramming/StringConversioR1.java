package DynamicProgramming;

public class StringConversioR1 {

    public static int findTotalInservertionAndDeletion(String str1, String str2) {

        if (str1.isEmpty() || str2.isEmpty()) {
            return 0;
        }
        if (str1.charAt(0) == str2.charAt(0)) {
            return 1 + findTotalInservertionAndDeletion(str1.substring(1), str2.substring(1));
        } else {
            int leftInclude = findTotalInservertionAndDeletion(str1.substring(1), str2);
            int rightInclude = findTotalInservertionAndDeletion(str1, str2.substring(1));
            return Math.max(leftInclude, rightInclude);
        }

    }

    public static int findLangestCommonSubsequece(String str1, String str2) {
        int row = str1.length();
        int column = str2.length();
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int leftValue = dp[i - 1][j];
                    int rightValue = dp[i][j - 1];
                    dp[i][j] = Math.max(leftValue, rightValue);
                }
            }
        }
        return dp[row][column];
    }

    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";

        // int commonValue = findTotalInservertionAndDeletion(str1, str2);
        int commonValue = findLangestCommonSubsequece(str1, str2);
        int totalDeletion = str1.length() - commonValue;
        int totalInsertion = str2.length() - commonValue;
        System.out.println("totalInserstiion " + totalInsertion + "I  " + "totalDeletion " + totalDeletion + "D");

    }

}
