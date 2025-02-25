package top150InterviewProblem.DPProblem.medium;

public class EditDistance {

    public static int findMin(String str1, String str2, int firstIndex, int secondIndex) {
        if (firstIndex < 0 && secondIndex >= 0) {
            return secondIndex + 1;
        }
        if (secondIndex < 0 && firstIndex >= 0) {
            return firstIndex + 1;
        }
        if (firstIndex < 0 || secondIndex < 0) {
            return 0;
        }
        if (str1.charAt(firstIndex) == str2.charAt(secondIndex)) {
            return findMin(str1, str2, firstIndex - 1, secondIndex - 1);
        } else {
            int insert = 1 + findMin(str1, str2, firstIndex, secondIndex - 1);
            int delete = 1 + findMin(str1, str2, firstIndex - 1, secondIndex);
            int replace = 1 + findMin(str1, str2, firstIndex - 1, secondIndex - 1);
            return Math.min(replace, Math.min(insert, delete));
        }
    }

    public static int findMinDynamic(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int row = 0; row <= str1.length(); row++) {
            for (int column = 0; column <= str2.length(); column++) {
                if (row == 0 && column == 0) {
                    dp[row][column] = 0;
                } else if (row == 0) {
                    dp[row][column] = column;
                } else if (column == 0) {
                    dp[row][column] = row;
                } else {
                    dp[row][column] = 0;
                }
            }
        }
        for (int row = 1; row <= str1.length(); row++) {
            for (int column = 1; column <= str2.length(); column++) {
                if (str1.charAt(row - 1) == str2.charAt(column - 1)) {
                    dp[row][column] = dp[row - 1][column - 1];
                } else {
                    int insert = 1 + dp[row][column - 1];
                    int delete = 1 + dp[row - 1][column];
                    int replace = 1 + dp[row - 1][column - 1];
                    dp[row][column] = Math.min(replace, Math.min(delete, insert));
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(findMin(word1, word2, word1.length() - 1, word2.length() - 1));
        System.out.println(findMinDynamic(word1, word2));
    }

}
