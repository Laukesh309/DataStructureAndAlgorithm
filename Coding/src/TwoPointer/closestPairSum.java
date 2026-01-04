package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;

public class closestPairSum {

    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void findPair(int arr[], int target) {
        Arrays.sort(arr);
        int maxDifference = Integer.MAX_VALUE;
        ArrayList<Integer> result = new ArrayList<>(2);
        result.add(0);
        result.add(0);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int leftValue = arr[left];
            int rightValue = arr[right];
            int sum = arr[left] + arr[right];
            int absDiff = Math.abs(sum - target);
            if (absDiff < maxDifference) {
                System.out.println(leftValue);
                result.set(0, leftValue);
                result.set(1, rightValue);
                maxDifference = absDiff;
            }
            if (sum == target) {
                left++;
                right--;

            } else if (sum < target) {
                left++;

            } else {
                right--;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 2, 7, 1, 4 }, target = 10;
        findPair(arr, target);
    }

}
