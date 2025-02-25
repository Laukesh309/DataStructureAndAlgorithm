package top150InterviewProblem.DPProblem.medium;

import java.util.Collections;
import java.util.HashMap;

public class NumberOfIncreasingSubSequence {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int findLangestIncreasingSubSequence(int arr[]) {
        int dp[] = new int[arr.length];
        int ct[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max = 1;
            ct[i] = 1;
            int totalCount = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && 1 + dp[j] > max) {
                    max = 1 + dp[j];
                    totalCount = 1;
                }
                if (1 + dp[j] == max) {
                    totalCount = ct[j] + totalCount;
                }
            }
            dp[i] = max;
            ct[i] = totalCount;

        }
        printArray(dp);
        printArray(ct);
        return 1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 3, 5, 4, 7, 2 };
        System.out.println(findLangestIncreasingSubSequence(arr));

    }

}
