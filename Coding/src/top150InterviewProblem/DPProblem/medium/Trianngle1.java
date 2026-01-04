package top150InterviewProblem.DPProblem.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trianngle1 {

    public static int findMinPath(List<List<Integer>> triangle, int currentRow, int nextRowIndex, int dp[][]) {
        int currentValue = triangle.get(currentRow).get(nextRowIndex);
        if (currentRow == triangle.size() - 1) {
            return currentValue;
        }
        if (dp[currentRow][nextRowIndex] != -1) {
            return dp[currentRow][nextRowIndex];
        }
        dp[currentRow][nextRowIndex] = currentValue + Math.min(findMinPath(triangle, currentRow + 1, nextRowIndex, dp),
                findMinPath(triangle, currentRow + 1, nextRowIndex + 1, dp));
        return dp[currentRow][nextRowIndex];
    }

    public static int findMinBottomTop(List<List<Integer>> triangle) {
        int dp[][] = new int[triangle.size()][];
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = new int[triangle.get(i).size()];
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j <= triangle.get(i - 1).size() - 1 && j - 1 >= 0) {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                } else if (j <= triangle.get(i - 1).size() - 1) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                } else if (j - 1 >= 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                }
            }
        }
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < dp[triangle.size() - 1].length; i++) {
            minValue = Math.min(minValue, dp[triangle.size() - 1][i]);
        }
        printArray(dp);
        System.out.println(minValue);
        return minValue;

    }

    public static void printArray(int dp[][]) {
        for (int[] is : dp) {
            for (int item : is) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        int tempTriangle[][] = { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };
        for (int[] tempArray : tempTriangle) {
            List<Integer> tempList = new ArrayList<>();
            for (int item : tempArray) {
                tempList.add(item);
            }
            triangle.add(tempList);

        }
        int n = triangle.size();
        int dp[][] = new int[n][];

        for (int i = 0; i < n; i++) {
            dp[i] = new int[triangle.get(i).size()];
            Arrays.fill(dp[i], -1);
        }
        // System.out.println(findMinPath(triangle, 0, 0, dp));
        findMinBottomTop(triangle);

    }

}
