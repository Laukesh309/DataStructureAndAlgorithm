package top150InterviewProblem.DPProblem.medium;

public class coinchange2 {

    public static int findTotalWays(int coin[], int currentIndex, int target) {
        if (currentIndex == 0) {
            if (target % coin[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (target < 0) {
            return 0;
        }
        int notTake = findTotalWays(coin, currentIndex - 1, target);
        int take = 0;
        if (coin[currentIndex] <= target) {
            take = findTotalWays(coin, currentIndex, target - coin[currentIndex]);
        }
        return notTake + take;
    }

    public static int findTotalWaysDynamic(int coin[], int totalAmount) {
        int dp[][] = new int[coin.length][totalAmount + 1];
        for (int column = 0; column <= totalAmount; column++) {
            dp[0][column] = column % coin[0] == 0 ? 1 : 0;
        }
        for (int row = 1; row < coin.length; row++) {
            for (int column = 0; column <= totalAmount; column++) {
                int notTake = dp[row - 1][column];
                int take = 0;
                if (coin[row] <= column) {
                    take = dp[row][column - coin[row]];
                }
                dp[row][column] = take + notTake;
            }
        }
        return dp[coin.length - 1][totalAmount];
    }

    public static void main(String[] args) {
        int coin[] = { 1, 2, 5 };
        int target = 5;
        System.out.println(findTotalWays(coin, coin.length - 1, target));
        System.out.println(findTotalWaysDynamic(coin, target));

    }

}
