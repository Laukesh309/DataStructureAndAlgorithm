package top150InterviewProblem.DPProblem.medium;

public class LongestComminSubSequence {

    public static String findAllSubSequence(String str1, String str2, int first, int second) {
        if (first < 0 || second < 0) {
            return "";
        }

        if (str1.charAt(first) == str2.charAt(second)) {
            return findAllSubSequence(str1, str2, first - 1, second - 1) + str2.charAt(second);
        } else {
            String left = findAllSubSequence(str1, str2, first - 1, second);
            String right = findAllSubSequence(str1, str2, first, second - 1);
            if (left.length() > right.length()) {
                return left;
            }
            return right;
        }
    }

    public static int findAllSubSequenceSDynamic(String str1, String str2) {
        int dp[][] = new int[str1.length()][str2.length()];
        for (int row = 0; row < str1.length(); row++) {
            for (int coloumn = 0; coloumn < str2.length(); coloumn++) {
                if (row == 0 && coloumn == 0) {
                    dp[row][coloumn] = str1.charAt(row) == str2.charAt(coloumn) ? 1 : 0;
                } else if (row == 0) {
                    dp[row][coloumn] = str1.charAt(row) == str2.charAt(coloumn) ? 1 : dp[row][coloumn - 1];
                } else if (coloumn == 0) {
                    dp[row][coloumn] = str1.charAt(row) == str2.charAt(coloumn) ? 1 : dp[row - 1][coloumn];
                }

            }
        }
        for (int row = 1; row < str1.length(); row++) {
            for (int column = 1; column < str2.length(); column++) {
                if (str1.charAt(row) == str2.charAt(column)) {
                    dp[row][column] = 1 + dp[row - 1][column - 1];
                } else {
                    dp[row][column] = Math.max(dp[row][column - 1], dp[row - 1][column]);
                }
            }
        }
        return dp[str1.length() - 1][str2.length() - 1];
    }

    public static String printAllSubSequenceDp(String str1, String str2) {
        String dp[][] = new String[str1.length()][str2.length()];
        for (int row = 0; row < str1.length(); row++) {
            for (int coloumn = 0; coloumn < str2.length(); coloumn++) {
                if (row == 0 && coloumn == 0) {
                    dp[row][coloumn] = str1.charAt(row) == str2.charAt(coloumn) ? "" + str1.charAt(row) : "";
                } else if (row == 0) {
                    dp[row][coloumn] = str1.charAt(row) == str2.charAt(coloumn) ? "" + str1.charAt(row)
                            : dp[row][coloumn - 1];
                } else if (coloumn == 0) {
                    dp[row][coloumn] = str1.charAt(row) == str2.charAt(coloumn) ? "" + str1.charAt(row)
                            : dp[row - 1][coloumn];
                }

            }
        }
        for (int row = 1; row < str1.length(); row++) {
            for (int column = 1; column < str2.length(); column++) {
                if (str1.charAt(row) == str2.charAt(column)) {
                    dp[row][column] = str1.charAt(row) + dp[row - 1][column - 1];
                } else {
                    if (dp[row][column - 1].length() > dp[row - 1][column].length()) {
                        dp[row][column] = dp[row][column - 1];
                    } else {
                        dp[row][column] = dp[row - 1][column];
                    }

                }
            }
        }
        return dp[str1.length() - 1][str2.length() - 1];

    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        System.out.println(findAllSubSequence(str1, str2, str1.length() - 1, str2.length() - 1));
        System.out.println(findAllSubSequenceSDynamic(str1, str2));
        System.out.println(printAllSubSequenceDp(str1, str2));

    }

}
