package recursion;

public class trailingProblem {

    public static int findTotalNumberOfWays(int totalLength, int totalWidth, int tileLength, int tileWidth) {
        if (totalWidth < 0) {
            return 0;
        }
        if (totalWidth == 0) {
            return 1;
        }
        int totalHorizentalWays = findTotalNumberOfWays(totalLength, totalWidth - tileLength, tileLength, tileWidth);
        int verticalWays = findTotalNumberOfWays(totalLength, totalWidth - tileWidth, tileLength, tileWidth);
        return totalHorizentalWays + verticalWays;
    }

    public static int findTotalWays(int totalWidth) {
        if (totalWidth == 0 || totalWidth == 1) {
            return 1;
        }
        int verticalWays = findTotalWays(totalWidth - 1);
        int horizentalWays = findTotalWays(totalWidth - 2);
        return verticalWays + horizentalWays;
    }

    public static int findTotalWaysByDynamic(int totalWidth, int dp[]) {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= totalWidth; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[totalWidth];
    }

    public static void main(String[] args) {
        int totalLength = 2;
        int totalWidth = 6;
        int tileLength = 2;
        int tileWidth = 1;
        int dp[] = new int[totalWidth + 1];
        // System.out.println(findTotalNumberOfWays(totalLength, totalWidth, tileLength,
        // tileWidth));
        System.out.println(findTotalWays(totalWidth));
        System.out.println(findTotalWaysByDynamic(totalWidth, dp));

    }

}
