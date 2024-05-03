package DynamicProgramming;

public class fibonacci {

    public static int fibonacci(int n, int arr[]) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = fibonacci(n - 1, arr) + fibonacci(n - 2, arr);
        return arr[n];
    }

    public static int findFibbonacciTabulisation(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= 5; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 6;
        int arr[] = new int[n + 1];
        System.out.println(fibonacci(n, arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println(findFibbonacciTabulisation(5));
    }

}
