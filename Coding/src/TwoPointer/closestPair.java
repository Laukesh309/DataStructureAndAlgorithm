package TwoPointer;

import java.util.ArrayList;

public class closestPair {

    public static int findClosestInddex(int brr[], int firstElement, int target) {
        int maxDifference = Integer.MAX_VALUE;
        int element = 0;
        int leftPointer = 0;
        int rightPointer = brr.length - 1;
        while (leftPointer <= rightPointer) {
            int mid = (leftPointer + rightPointer) / 2;
            int sum = brr[mid] + firstElement;
            int absDiff = Math.abs(sum - target);
            if (absDiff < maxDifference) {
                element = brr[mid];
                maxDifference = absDiff;
            }
            if (sum == target) {
                return element;
            }
            if (sum < target) {
                leftPointer = mid + 1;
            } else {
                rightPointer = mid - 1;
            }
        }
        return element;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 5, 7 };
        int brr[] = { 10, 20, 30, 40 };
        int totalabs = Integer.MAX_VALUE;
        int X = 32;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(0);
        for (int i = 0; i < arr.length; i++) {
            int firstElement = arr[i];
            int secondElement = findClosestInddex(brr, firstElement, X);
            int total = firstElement + secondElement;
            if (Math.abs(total - X) < totalabs) {
                totalabs = Math.abs(total - X);
                result.set(0, firstElement);
                result.set(1, secondElement);
            }
        }
        System.out.println(result);

    }

}
