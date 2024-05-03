package DynamicProgramming;

import java.util.ArrayList;

public class TargetSumSubset {

    public static void findMaxSum(int totalNumber[], int currentIndex, int targetSum, String stc, int dp[][]) {
        if (targetSum == 0) {
            System.out.println(stc);
            return;
        }
        if (currentIndex >= totalNumber.length || targetSum <= 0) {
            return;
        }
        findMaxSum(totalNumber, currentIndex + 1, targetSum - totalNumber[currentIndex],
                stc + totalNumber[currentIndex], dp);
        // stc.remove(totalNumber[currentIndex]);
        findMaxSum(totalNumber, currentIndex + 1, targetSum, stc, dp);
    }

    public static void main(String[] args) {
        int totalNumber[] = { 4, 2, 7, 1, 3 };
        int targetSum = 10;
        String result = "";
        int dp[][] = new int[totalNumber.length + 1][targetSum + 1];
        findMaxSum(totalNumber, 0, targetSum, result, dp);
    }

}
