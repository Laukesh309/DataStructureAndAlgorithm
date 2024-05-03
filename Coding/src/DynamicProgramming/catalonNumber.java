package DynamicProgramming;

public class catalonNumber {

    public static int findCatalonNumber(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += findCatalonNumber(i, dp) * findCatalonNumber(n - i - 1, dp);
        }
        dp[n] = ans;
        return dp[n];
    }

    public static void printDp(int dp[]) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
    }

    public static int findCatalognBytabulisationn(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int ans = 0;
            for (int j = 0, k = i - 1; j < i && k >= 0; j++, k--) {
                ans += dp[j] * dp[k];
            }
            dp[i] = ans;
        }
        // printDp(dp);
        return dp[n];
    }

    public static int findCatalognBytabulisationnWhileMethod(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int inititalPointer = 0;
            int lastPointer = i - 1;
            int ans = 0;
            while (inititalPointer < i && lastPointer >= 0) {
                ans += dp[inititalPointer] * dp[lastPointer];
                inititalPointer++;
                lastPointer--;
            }
            dp[i] = ans;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 1;
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        System.out.println(findCatalonNumber(n, dp));
        // printDp(dp);
        System.out.println(findCatalognBytabulisationn(n));
        System.out.println(findCatalognBytabulisationnWhileMethod(n));
    }

}
