package top150InterviewProblem.DPProblem.medium;

public class editDistance1 {

    public static int findMinOperation(String word1, String word2, int firstIndex, int secondIndex) {
        if (firstIndex >= word1.length() && secondIndex >= word2.length()) {
            return 0;
        }
        if (firstIndex >= word1.length()) {
            return word2.length() - secondIndex;
        }
        if (secondIndex >= word2.length()) {
            return word1.length() - firstIndex;
        }

        if (word1.charAt(firstIndex) == word2.charAt(secondIndex)) {
            return findMinOperation(word1, word2, firstIndex + 1, secondIndex + 1);
        } else {
            int insert = findMinOperation(word1, word2, firstIndex, secondIndex + 1);
            int delete = findMinOperation(word1, word2, firstIndex + 1, secondIndex);
            int replace = findMinOperation(word1, word2, firstIndex + 1, secondIndex + 1);
            return 1 + Math.min(replace, Math.min(insert, delete));
        }
    }

    public static int findMinOperationDynamic(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int row = 0; row <= word1.length(); row++) {
            for (int col = 0; col <= word2.length(); col++) {
                if (row == 0 && col == 0) {
                    dp[0][0] = 0;
                } else if (row == 0) {
                    dp[row][col] = col;
                } else if (col == 0) {
                    dp[row][col] = row;
                }

            }
        }
        for (int row = 1; row <= word1.length(); row++) {
            for (int col = 1; col <= word2.length(); col++) {
                if (word2.charAt(col - 1) == word1.charAt(row - 1)) {
                    dp[row][col] = dp[row - 1][col - 1];
                } else {
                    int delete = dp[row - 1][col];
                    int replace = dp[row - 1][col - 1];
                    int insert = dp[row][col - 1];
                    dp[row][col] = 1 + Math.min(delete, Math.min(replace, insert));
                }
            }
        }
        System.out.println(dp[word1.length()][word2.length()]);
        return 0;
    }

    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(findMinOperation(word1, word2, 0, 0));
        System.out.println(findMinOperationDynamic(word1, word2));
    }

}
