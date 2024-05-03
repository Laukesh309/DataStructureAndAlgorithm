package DynamicProgramming;

public class mcm {

    public static int findMinSubSet(int arr[], int initialMatrix, int lastMatrix, int dp[][]) {

        if (initialMatrix == lastMatrix) {
            return 0;
        }
        if (dp[initialMatrix][lastMatrix] != 0) {
            return dp[initialMatrix][lastMatrix];
        }
        int ans = Integer.MAX_VALUE;
        for (int k = initialMatrix; k < lastMatrix; k++) {
            int leftCast = findMinSubSet(arr, initialMatrix, k, dp);
            int rightCast = findMinSubSet(arr, k + 1, lastMatrix, dp);
            int totalCast = arr[initialMatrix - 1] * arr[k] * arr[lastMatrix];
            int finalCast = leftCast + rightCast + totalCast;
            ans = Math.min(ans, finalCast);
            dp[initialMatrix][lastMatrix] = ans;
            // return ans;

        }
        return dp[initialMatrix][lastMatrix];

    }

    public static void printDp(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMinTabulisation(int arr[]) {
        int dp[][] = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i >= j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }

        }

        for (int length = 2; length < arr.length; length++) {
            for (int i = 1; i <= arr.length - length; i++) {
                int column = i + length - 1;
                dp[i][column] = Integer.MAX_VALUE;
                for (int k = i; k < column; k++) {
                    int cast1 = dp[i][k];
                    int cast2 = dp[k + 1][column];
                    int currentCast = cast1 + cast2 + arr[i - 1] * arr[k] * arr[column];
                    dp[i][column] = Math.min(dp[i][column], currentCast);
                }
            }
        }
        return dp[1][arr.length - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 3 };
        int dp[][] = new int[arr.length][arr.length];
        System.out.println(findMinSubSet(arr, 1, arr.length - 1, dp));
        System.out.println(findMinTabulisation(arr));

    }

}
