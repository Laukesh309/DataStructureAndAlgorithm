package top150InterviewProblem.DPProblem.medium;

import java.util.Arrays;

public class coinchange {

    public static int findTotalCount(int coin[], int currentIndex, int totalCount, int sum, int totalAmount) {
        if (totalAmount == sum) {
            return totalCount;
        }
        if (currentIndex < 0 || sum > totalAmount) {
            return Integer.MAX_VALUE;
        }

        int included = findTotalCount(coin, currentIndex, totalCount + 1, sum + coin[currentIndex], totalAmount);
        int excluded = findTotalCount(coin, currentIndex - 1, totalCount, sum, totalAmount);
        return Math.min(included, excluded);

    }

    public static void main(String[] args) {
        int coin[] = { 1 };
        int amount = 0;
        Arrays.sort(coin);
        if (findTotalCount(coin, coin.length - 1, 0, 0, amount) == Integer.MAX_VALUE) {
            System.out.println("-1");

        } else {
            System.out.println(findTotalCount(coin, coin.length - 1, 0, 0, amount));
        }

    }

}
