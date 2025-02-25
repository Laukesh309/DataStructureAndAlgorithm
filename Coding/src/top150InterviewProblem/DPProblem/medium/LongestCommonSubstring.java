package top150InterviewProblem.DPProblem.medium;

public class LongestCommonSubstring {

    public static int findLangestSubString(String str1, String str2, int firstIndex, int lastIndex, int result) {
        if (firstIndex < 0 || lastIndex < 0) {
            return 0;
        }
        if (str1.charAt(firstIndex) == str2.charAt(lastIndex)) {
            return findLangestSubString(str1, str2, firstIndex - 1, lastIndex - 1, result + 1);
        } else {
            int left = findLangestSubString(str1, str2, firstIndex, lastIndex - 1, 0);
            int right = findLangestSubString(str1, str2, firstIndex - 1, lastIndex, 0);
            return Math.max(result, Math.max(left, right));
        }
    }

    public static int findAllSubStringDynamic(String str1, String str2) {
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        int max = 0;
        for (int row = 1; row <= str1.length(); row++) {
            for (int column = 1; column <= str2.length(); column++) {
                if (str1.charAt(row - 1) == str2.charAt(column - 1)) {
                    dp[row][column] = 1 + dp[row - 1][column - 1];
                } else {
                    dp[row][column] = 0;
                }
                max = Math.max(max, dp[row][column]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str1 = "abcjklp";
        String str2 = "acjkp";
        System.out.println(findLangestSubString(str1, str2, str1.length() - 1, str2.length() - 1, 0));
        System.out.println(findAllSubStringDynamic(str1, str2));
    }

}
