package GFGDynamicProgrammin;

public class LangestIncreasingSubSequence {

    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static int findMax(int arr[]) {
        int dp[] = new int[arr.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(1 + dp[j], dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        printArray(dp);
        System.out.println(max);
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = { 22, 34, 36, 30 };
        findMax(arr);
    }

}
