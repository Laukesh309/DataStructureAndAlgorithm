package top150InterviewProblem.DPProblem.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestDivisiblePairSubSet {

    public static boolean checkIsDivisible(List<Integer> temp, int currentData) {
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) % currentData != 0 && currentData % temp.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findLargestPair(int arr[], int currentIndex, ArrayList<Integer> result) {
        if (currentIndex >= arr.length) {
            return result;
        }
        List<Integer> notTake = findLargestPair(arr, currentIndex + 1, new ArrayList<>(result));
        List<Integer> take = new ArrayList<>();
        if (checkIsDivisible(result, arr[currentIndex])) {
            result.add(arr[currentIndex]);
            take = findLargestPair(arr, currentIndex + 1, new ArrayList<>(result));
        }
        if (notTake.size() > take.size()) {
            return notTake;
        } else {
            return take;
        }

    }

    public static List<Integer> findLargestDivisiblePairDynamic(int arr[]) {
        int dp[] = new int[arr.length];
        int hash[] = new int[arr.length];
        int max = 1;
        int lastIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            hash[i] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }

            }
            if (dp[i] > max) {
                max = dp[i];
                lastIndex = i;
            }
        }
        int currentIndex = lastIndex;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(arr[lastIndex]);
        while (hash[currentIndex] != currentIndex) {
            result.add(arr[hash[currentIndex]]);
            currentIndex = hash[currentIndex];
        }
        return result;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 4, 8 };
        Arrays.sort(arr);
        System.out.println(findLargestPair(arr, 0, new ArrayList<>()));
        System.out.println(findLargestDivisiblePairDynamic(arr));

    }

}
