package Sheet.String.Medium;

public class NoOfPelindromicSubString {

    public static boolean checkPelindrome(String str) {
        StringBuilder str1 = new StringBuilder();
        str1.append(str);
        str1.reverse();
        return str.equals(str1.toString());

    }

    public static int totalPelindromic(String str) {
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (checkPelindrome(str.substring(i, j))) {
                    total++;
                }

            }
        }
        return total;
    }

    public static int findTotalPelindrome(String str) {
        int total = 0;
        boolean dp[][] = new boolean[str.length()][str.length()];
        for (int row = 0; row < str.length(); row++) {
            for (int column = 0; column < str.length(); column++) {
                if (row >= column) {
                    dp[row][column] = true;
                    if (row == column) {
                        total++;
                    }

                }
            }
        }
        for (int row = str.length() - 1; row >= 0; row--) {
            for (int column = row + 1; column < str.length(); column++) {
                if (str.charAt(row) == str.charAt(column)) {
                    dp[row][column] = dp[row + 1][column - 1];
                } else {
                    dp[row][column] = false;
                }
                if (dp[row][column]) {
                    total++;
                }

            }
        }
        return total;

    }

    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(totalPelindromic(str));
        System.out.println(findTotalPelindrome(str));
    }

}
