package top150InterviewProblem.DPTwoDimenstion;

public class EditDistance {

    public static int findMin(String str1, String str2) {

        if (str1.equals(str2)) {
            return 0;
        }
        if (str1.isEmpty()) {
            return str2.length();
        }
        if (str2.isEmpty()) {
            return str1.length();

        }
        if (str1.charAt(0) == str2.charAt(0)) {
            return findMin(str1.substring(1), str2.substring(1));
        }
        int insert = findMin(str1, str2.substring(1));
        int replace = findMin(str1.substring(1), str2.substring(1));
        int delete = findMin(str1.substring(1), str2);
        int result = Math.min(Math.min(replace, delete), insert);
        return result + 1;
    }

    public static int findEditDistanceDynamic(String word1, String word2) {
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int row = 1; row <= word1.length(); row++) {
            for (int column = 1; column <= word2.length(); column++) {
                if (word1.charAt(row - 1) == word2.charAt(column - 1)) {
                    dp[row][column] = dp[row - 1][column - 1];
                } else {
                    int delete = dp[row - 1][column];
                    int replace = dp[row - 1][column - 1];
                    int insert = dp[row][column - 1];
                    dp[row][column] = 1 + Math.min(Math.min(delete, replace), insert);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(findMin(word1, word2));
        System.out.println(findEditDistanceDynamic(word1, word2));
    }

}
