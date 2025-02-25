package top150InterviewProblem.DPProblem.medium;

public class MatrixChainMultiplication1 {

    public static int findMinMultiplication(int arr[], int i, int j, int dp[][]) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int totalCount = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int currentValue = arr[i - 1] * arr[k] * arr[j];
            int leftValue = findMinMultiplication(arr, i, k, dp);
            int righTValue = findMinMultiplication(arr, k + 1, j, dp);
            totalCount = Math.min(totalCount, currentValue + leftValue + righTValue);
        }
        dp[i][j] = totalCount;
        return dp[i][j];
    }

    public static int findMax(int arr[], int startMatrixIndex, int endMatrixIndex) {
        if (startMatrixIndex == endMatrixIndex) {
            return 0;
        }
        int totalValue = Integer.MAX_VALUE;
        for (int k = startMatrixIndex; k < endMatrixIndex; k++) {
            int currentMatrixIndexValue = arr[startMatrixIndex] * arr[k + 1] * arr[endMatrixIndex + 1];
            int leftValue = findMax(arr, startMatrixIndex, k);
            int righValue = findMax(arr, k + 1, endMatrixIndex);
            totalValue = Math.min(totalValue, currentMatrixIndexValue + leftValue + righValue);
        }
        return totalValue;
    }

    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMatrixMulticationDynamic(int arr[]) {
        int totalMatrix = arr.length - 1;
        int dp[][] = new int[totalMatrix][totalMatrix];
        for (int i = totalMatrix - 1; i >= 0; i--) {
            for (int j = i + 1; j < totalMatrix; j++) {
                int totalValue = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int currentValue = arr[i] * arr[k + 1] * arr[j + 1];
                    int leftValue = dp[i][k];
                    int righTValue = dp[k + 1][j];
                    totalValue = Math.min(totalValue, currentValue + righTValue + leftValue);
                }
                dp[i][j] = totalValue;
            }
        }
        return dp[0][totalMatrix - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int dp[][] = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(findMinMultiplication(arr, 1, arr.length - 1, dp));
        int totalMatrix = arr.length - 1;
        System.out.println(findMax(arr, 0, totalMatrix - 1));
        System.out.println(findMatrixMulticationDynamic(arr));
    }

}
