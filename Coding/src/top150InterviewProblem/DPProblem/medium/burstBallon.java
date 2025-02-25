package top150InterviewProblem.DPProblem.medium;

public class burstBallon {

    public static int findMaxValue(int start, int end, int newArray[], int dp[][]) {
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != -1) {
            return dp[start][end];
        }

        int result = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            int currentValue = newArray[start - 1] * newArray[i] * newArray[end + 1];
            int leftValue = findMaxValue(start, i - 1, newArray, dp);
            int righValue = findMaxValue(i + 1, end, newArray, dp);
            result = Math.max(result, currentValue + leftValue + righValue);
        }
        dp[start][end] = result;
        return dp[start][end];
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 5, 8 };
        int newArray[] = new int[arr.length + 2];
        int dp[][] = new int[arr.length + 2][arr.length + 2];
        newArray[0] = 1;
        newArray[newArray.length - 1] = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 1; i <= arr.length; i++) {
            newArray[i] = arr[i - 1];
        }
        System.out.println(findMaxValue(1, newArray.length - 2, newArray, dp));
    }

}
