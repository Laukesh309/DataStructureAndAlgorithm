package GFGDynamicProgrammin;

public class CountNumberOfHops {

    public static int findTotalStep(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 0) {
            return 1;
        }
        return findTotalStep(n - 1) + findTotalStep(n - 2) + findTotalStep(n - 3);
    }

    public static int findTotalStepDynamic(int n) {

        int dp[] = new int[n + 1];
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(findTotalStep(n));
        System.out.println(findTotalStepDynamic(n));
    }

}
