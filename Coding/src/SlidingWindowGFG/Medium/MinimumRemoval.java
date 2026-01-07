package SlidingWindowGFG.Medium;

import java.util.HashMap;

import GraphCode.cityWithSmallestNeobhour;
import TreeStriver.symetryTree;

public class MinimumRemoval {

    public static int findMinimumRemoval(int arr[], int k) {
        int totalSum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
            if (!hm.containsKey(totalSum)) {
                hm.put(totalSum, i);
            }
        }
        if (totalSum < k) {
            return -1;
        }
        int remainingSum = totalSum - k;
        System.out.println(remainingSum);
        int currentSum = 0;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            if (hm.containsKey(currentSum - remainingSum)) {
                maxLength = Math.max(maxLength, i - hm.get(currentSum - remainingSum));
            }
        }
        if (maxLength == Integer.MAX_VALUE) {
            return -1;
        }

        // for(int i=)
        return maxLength;
    }

    public static int findMin(int arr[], int k) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        if (total < k) {
            return -1;
        }
        int left = 0;
        int right = 0;
        int totalLength = Integer.MIN_VALUE;
        int currentSum = 0;
        int remainingSum = total - k;
        while (right < arr.length) {
            currentSum = currentSum + arr[right];
            while (currentSum > remainingSum) {
                currentSum = currentSum - arr[left];
                left++;
            }
            if (currentSum == remainingSum) {
                totalLength = Math.max(totalLength, right - left + 1);
            }
            right++;
        }
        if (totalLength == Integer.MIN_VALUE) {
            return -1;
        } else {
            return arr.length - totalLength;
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 1, 3, 1, 2 };
        int arr[] = { 6, 3, 1, 2, 10, 10 };
        int k = 20;
        System.out.println(findMinimumRemoval(arr, k));
        System.out.println(findMin(arr, k));
    }

}
