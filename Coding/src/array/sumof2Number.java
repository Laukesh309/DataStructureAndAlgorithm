package array;

import java.util.Arrays;
import java.util.HashMap;

public class sumof2Number {

    // public static void findSumOfNumber(int arr[], int target) {
    // Arrays.sort(arr);
    // int firstPointer = 0;
    // int lastPointer = arr.length - 1;
    // while (firstPointer < lastPointer) {
    // int sum = arr[firstPointer] + arr[lastPointer];

    // if (sum == target) {
    // System.out.println("found " + firstPointer + " lastPointer " + lastPointer);
    // return;
    // } else if (sum > target) {
    // lastPointer--;
    // } else {
    // firstPointer++;
    // }
    // }
    // System.out.println("Not Found");
    // return;
    // }
    public static int[] findSumOfNumber(int arr[], int target) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        int resultArray[] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (hs.containsKey(target - num)) {
                resultArray[0] = hs.get(target - num);
                resultArray[1] = i;
                return resultArray;
            } else {
                hs.put(num, i);
            }
        }

    }

    public static void main(String[] args) {
        // int num[] = { 2, 7, 11, 15 };
        // int num[] = { 3, 2, 4 };
        int num[] = { 3, 3 };
        int targetValue = 6;
        findSumOfNumber(num, targetValue);
    }

}
