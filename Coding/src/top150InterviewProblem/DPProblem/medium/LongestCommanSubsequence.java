package top150InterviewProblem.DPProblem.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LongestCommanSubsequence {

    public static int findMaxSumSequence(int nums[], int currentIndex, int currentResult, int currentValue) {
        if (currentIndex < 0) {
            return currentResult;
        }
        if (nums[currentIndex] < currentValue) {
            return Math.max(
                    findMaxSumSequence(nums, currentIndex - 1, currentResult + 1, nums[currentIndex]),
                    findMaxSumSequence(nums, currentIndex - 1, currentResult, currentValue));

        } else {
            int takeValue = findMaxSumSequence(nums, currentIndex - 1, currentResult, currentValue);
            int nonTakeValue = findMaxSumSequence(nums, currentIndex - 1, 1, nums[currentIndex]);
            return Math.max(takeValue, nonTakeValue);

        }
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void printDpArray(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findLangestSubSequenceDynamic(int nums[]) {
        ArrayList<Integer> hs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hs.contains(nums[i])) {
                hs.add(nums[i]);
            }
        }
        Collections.sort(hs);
        System.out.println(hs);
        int dp[][] = new int[nums.length + 1][hs.size() + 1];
        dp[0][0] = 0;
        for (int row = 1; row <= nums.length; row++) {
            for (int coloumn = 1; coloumn <= hs.size(); coloumn++) {
                if (nums[row - 1] == hs.get(coloumn - 1)) {
                    dp[row][coloumn] = 1 + dp[row - 1][coloumn - 1];
                } else {
                    dp[row][coloumn] = Math.max(dp[row][coloumn - 1], dp[row - 1][coloumn]);
                }
            }
        }
        return dp[nums.length][hs.size()];
    }

    public static void main(String[] args) {
        int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(findMaxSumSequence(nums, nums.length - 1, 0, Integer.MAX_VALUE));
        // findLangestSubSequence(nums);
        System.out.println(findLangestSubSequenceDynamic(nums));
    }

}
