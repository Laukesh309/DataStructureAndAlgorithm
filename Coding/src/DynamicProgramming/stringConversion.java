package DynamicProgramming;

public class stringConversion {

    public static int findMin(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty()) {
            return 0;
        }
        if (str1.isEmpty() && !str2.isEmpty()) {
            return str2.length();
        }
        if (!str1.isEmpty() && str2.isEmpty()) {
            return str1.length();
        }
        if (str1.charAt(0) != str2.charAt(0)) {
            int add = findMin(str1, str2.substring(1)) + 1;
            int delete = findMin(str1.substring(1), str2) + 1;
            return Math.min(add, delete);
        }
        return findMin(str1.substring(1), str2.substring(1));
    }

    public static int findMinByTabulisation(String str1, String str2) {
        int row = str2.length();
        int column = str1.length();
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
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
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = 1 + dp[i - 1][j];
                    int delete = 1 + dp[i][j - 1];
                    dp[i][j] = Math.min(add, delete);
                }
            }
        }
        return dp[row][column];
    }

    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";
        // String str1 = "abcdef";
        // String str2 = "aceg";
        System.out.println(findMin(str1, str2));
        System.out.println(findMinByTabulisation(str1, str2));
    }

}
