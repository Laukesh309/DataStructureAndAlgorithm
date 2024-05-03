package DynamicProgramming;

public class longestCommonSubsequenceContineous {

    public static int findMaxValueByRecursion(String str1, String str2, int currentMax, int firstIndex,
            int secondIndex) {
        if (firstIndex >= str1.length() || secondIndex >= str2.length()) {
            return currentMax;
        }
        if (str1.charAt(firstIndex) == str2.charAt(secondIndex)) {
            return findMaxValueByRecursion(str1, str2, currentMax + 1, firstIndex + 1, secondIndex + 1);
        } else {
            int maxValue = currentMax;
            int firstIncluded = findMaxValueByRecursion(str1, str2, 0, firstIndex + 1, secondIndex);
            int secondInclude = findMaxValueByRecursion(str1, str2, 0, firstIndex, secondIndex + 1);
            return Math.max(Math.max(maxValue, firstIncluded), secondInclude);
        }

    }

    public static int findMaxValueSecondApproach(String str1, String str2, int currentMax, int maxValue, int firstIndex,
            int secondIndex) {
        if (firstIndex >= str1.length() || str2.length() <= secondIndex) {
            return maxValue;
        }
        if (str1.charAt(firstIndex) == str2.charAt(secondIndex)) {
            int currentValue = currentMax + 1;
            return findMaxValueSecondApproach(str1, str2, currentMax + 1, Math.max(maxValue, currentValue),
                    firstIndex + 1, secondIndex + 1);
        } else {
            return Math.max(
                    findMaxValueSecondApproach(str1, str2, 0, Math.max(maxValue, currentMax), firstIndex + 1,
                            secondIndex),
                    findMaxValueSecondApproach(str1, str2, 0, Math.max(maxValue, currentMax), firstIndex,
                            secondIndex + 1));
        }
    }

    /// here we check string by including this character

    public static int findSequenceByTabulisation(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int maxValue = 0;
        int dp[][] = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxValue = Math.max(maxValue, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        String str1 = "ABCDE";
        String str2 = "ABGCE";
        // String str1 = "ABCDGH";
        // String str2 = "ACDGHR";
        System.out.println(findMaxValueByRecursion(str1, str2, 0, 0, 0));
        System.out.println(findMaxValueSecondApproach(str1, str2, 0, 0, 0, 0));
        System.out.println(findSequenceByTabulisation(str1, str2));

    }

}
