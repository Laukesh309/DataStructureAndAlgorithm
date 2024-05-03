package DynamicProgramming;

public class addDelete {

    public static int findMinimumAddition(String str1, String str2) {

        int firstLength = str1.length();
        int secondLength = str2.length();
        int dp[][] = new int[firstLength + 1][secondLength + 1];
        for (int i = 0; i <= firstLength; i++) {
            for (int j = 0; j <= secondLength; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }

            }
        }

        for (int i = 1; i <= firstLength; i++) {

            for (int j = 1; j <= secondLength; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = 1 + dp[i - 1][j];
                    int delete = 1 + dp[i][j - 1];
                    dp[i][j] = Math.min(add, delete);

                }
            }
        }
        return dp[firstLength][secondLength];
    }

    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";
        System.out.println(findMinimumAddition(str1, str2));

    }

}
