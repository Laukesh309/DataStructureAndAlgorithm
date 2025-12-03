package top150InterviewProblem.DPTwoDimenstion;

public class LongestPalindromicSubString {

    public static String findLangestPalindromic(String str) {
        String str2 = new StringBuilder(str).reverse().toString();
        String dp[][] = new String[str.length() + 1][str2.length() + 1];
        String max = "";
        for (int i = 0; i <= str.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                dp[i][j] = "";
            }
        }

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 1; j <= str.length(); j++) {
                if (str.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = str.charAt(i - 1) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = "";
                }
                if (dp[i][j].length() > max.length()) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    public static int findLangest(String str) {
        int max = Integer.MIN_VALUE;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
            }

            if (max < right - left - 1) {
                result = str.substring(left + 1, right);
            }
            max = Math.max(max, right - left - 1);
            left = i;
            right = i + 1;
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
            }
            if (max < right - left - 1) {
                result = str.substring(left + 1, right);
            }
            max = Math.max(max, right - left - 1);
        }
        System.out.println(result);
        return max;
    }

    public static void main(String[] args) {
        String str = "babad";
        System.out.println(findLangestPalindromic(str));
        System.out.println(findLangest(str));

    }
}
