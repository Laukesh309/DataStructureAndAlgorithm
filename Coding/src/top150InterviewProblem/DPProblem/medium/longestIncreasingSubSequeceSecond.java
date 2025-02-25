package top150InterviewProblem.DPProblem.medium;

import java.util.Collections;

// https://leetcode.com/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-interview-150

public class longestIncreasingSubSequeceSecond {

    public static int findIncreasingSubSequencebyRecursion(int arr[], int currentIndex, int prevValue, int result) {
        if (currentIndex < 0) {
            return result;
        }
        if (arr[currentIndex] < prevValue) {
            return Math.max(findIncreasingSubSequencebyRecursion(arr, currentIndex - 1, arr[currentIndex], result + 1),
                    findIncreasingSubSequencebyRecursion(arr, currentIndex - 1, prevValue, result));
        } else {
            int left = findIncreasingSubSequencebyRecursion(arr, currentIndex, Integer.MAX_VALUE, 0);
            int right = findIncreasingSubSequencebyRecursion(arr, currentIndex - 1, prevValue, result);
            return Math.max(left, right);
        }
    }

    public static int findLongestSubSequence(int arr[]) {
        int dp[] = new int[arr.length];
        int MaximuxValue = 1;
        for (int i = 0; i < arr.length; i++) {
            int max = 1;
            int currentMax = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < currentMax) {
                    max = Math.max(1 + dp[j], max);
                }
            }
            dp[i] = max;
            MaximuxValue = Math.max(max, MaximuxValue);
        }
        return MaximuxValue;

    }

    public static int findMaxIncreasingSubSequence(int arr[], int currentIndex, int prevIndex) {
        if (currentIndex == arr.length) {
            return 0;
        }
        int notTake = findMaxIncreasingSubSequence(arr, currentIndex + 1, prevIndex);
        int take = 0;
        if (prevIndex == -1 || arr[currentIndex] > arr[prevIndex]) {
            take = 1 + findMaxIncreasingSubSequence(arr, currentIndex + 1, currentIndex);
        }
        return Math.max(notTake, take);
    }

    public static int findMaxIncreasingSubSequenceDynamic(int arr[], int currentIndex, int prevIndex, int dp[][]) {
        if (currentIndex - 1 == arr.length) {
            return 0;
        }
        if (dp[currentIndex][prevIndex] != 0) {
            return dp[currentIndex][prevIndex];
        }
        int notTake = findMaxIncreasingSubSequenceDynamic(arr, currentIndex + 1, prevIndex, dp);
        int take = 0;
        if (prevIndex == 0 || arr[currentIndex - 1] > arr[prevIndex - 1]) {
            take = 1 + findMaxIncreasingSubSequenceDynamic(arr, currentIndex + 1, currentIndex, dp);
        }
        dp[currentIndex][prevIndex] = Math.max(notTake, take);
        return dp[currentIndex][prevIndex];

    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 3, 2, 3 };
        int dp[][] = new int[arr.length + 1][arr.length + 1];
        System.out.println(findIncreasingSubSequencebyRecursion(arr, arr.length - 1, Integer.MAX_VALUE, 0));
        System.out.println(findLongestSubSequence(arr));
        System.out.println(findMaxIncreasingSubSequence(arr, 0, -1));
        System.out.println(findMaxIncreasingSubSequenceDynamic(arr, 1, 0, dp));

    }
}
