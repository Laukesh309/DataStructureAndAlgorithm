package DynamicProgramming;

public class EditString {

    public static int findMinimumNumber(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty()) {
            return 0;
        }
        if (str1.length() == str2.length()) {
            if (str1.charAt(str1.length() - 1) != str2.charAt(str2.length() - 1)) {
                System.out.println("Replace");
                return 1 + findMinimumNumber(str1.substring(0, str1.length() - 1),
                        str2.substring(0, str2.length() - 1));
            } else {
                return findMinimumNumber(str1.substring(0, str1.length() - 1),
                        str2.substring(0, str2.length() - 1));
            }
        } else {
            if (str1.length() < str2.length()) {
                System.out.println("Insert");
                return 1 + findMinimumNumber(str1, str2.substring(0, str2.length() - 1));
            } else {
                System.out.println("Delete");
                return 1 + findMinimumNumber(str1.substring(0, str1.length() - 1), str2);
            }
        }
    }

    public static int findMinByTablisation(String str1, String str2) {
        int firstStringLength = str1.length();
        int secondStringLength = str2.length();
        int dp[][] = new int[firstStringLength + 1][secondStringLength + 1];
        for (int i = 0; i <= firstStringLength; i++) {
            for (int j = 0; j <= secondStringLength; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }
        for (int i = 1; i <= firstStringLength; i++) {
            for (int j = 1; j <= secondStringLength; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int add = 1 + dp[i - 1][j];
                    int delete = 1 + dp[i][j - 1];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(Math.min(add, replace), delete);
                }
            }
        }
        return dp[firstStringLength][secondStringLength];
    }

    public static void main(String[] args) {
        // String str1 = "invention";
        // String str2 = "execution";
        // String str1 = "abc";
        // String str2 = "adkkkkkkd";
        String str1 = "abcdef";
        String str2 = "bdef";
        System.out.println(findMinimumNumber(str1, str2));
        System.out.println(findMinByTablisation(str1, str2));
    }

}
