package TwoPointerGFG.Medium;

import java.util.Arrays;

public class tripelFamiliy {

    public static boolean findTriplet(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];
            int leftPointer = 0;
            int rightPointer = i - 1;
            while (leftPointer < rightPointer) {
                int totalSum = arr[leftPointer] + arr[rightPointer];
                if (totalSum == target) {
                    return true;
                }
                if (totalSum > target) {
                    rightPointer--;
                } else {
                    leftPointer++;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5 };
        Arrays.sort(arr);
        System.out.println(findTriplet(arr));
    }

}
