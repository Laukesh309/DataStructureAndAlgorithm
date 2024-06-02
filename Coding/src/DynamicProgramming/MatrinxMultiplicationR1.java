package DynamicProgramming;

public class MatrinxMultiplicationR1 {

    public static int findMinMultiplication(int arr[], int initialPointer, int lastPointer) {
        if (initialPointer == lastPointer) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for (int k = initialPointer; k <= lastPointer - 1; k++) {
            int leftData = findMinMultiplication(arr, initialPointer, k);
            int rightData = findMinMultiplication(arr, k + 1, lastPointer);
            int currentData = arr[initialPointer] * arr[k + 1] * arr[lastPointer + 1];
            int totalValue = leftData + rightData + currentData;
            result = Math.min(result, totalValue);
        }
        return result;
    }

    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMinValue(int arr[]) {
        int totalMatrix = arr.length - 1;
        int row = totalMatrix - 1;
        int column = totalMatrix - 1;
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= column; j++) {
                if (i <= j) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = i + 1; j <= column; j++) {
                int result = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int leftValue = dp[i][k];
                    int rightValue = dp[k + 1][j];
                    int currentValue = arr[i] * arr[k + 1] * arr[j + 1];
                    int totalValue = leftValue + rightValue + currentValue;
                    result = Math.min(result, totalValue);
                }
                dp[i][j] = result;

            }
        }
        printDp(dp);
        return dp[0][column];
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 3 };
        int lastPointer = arr.length - 2;
        System.out.println(findMinMultiplication(arr, 0, lastPointer));
        System.out.println(findMinValue(arr));

    }

}
