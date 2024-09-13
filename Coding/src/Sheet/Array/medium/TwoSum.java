package Sheet.Array.medium;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

    public static void printArray(int arr[]) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static int[] getTargetIndex(int arr[], int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int resullt[] = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(target - arr[i])) {
                resullt[0] = hm.get(target - arr[i]);
                resullt[1] = i;
                break;
            }
            hm.put(arr[i], i);
        }
        return resullt;
    }

    // public int[] twoSum(int[] arr, int target) {
    // HashMap<Integer, Integer> hs = new HashMap<>();
    // int resultArray[] = new int[2];
    // for (int i = 0; i < arr.length; i++) {
    // int num = arr[i];
    // if (hs.containsKey(target - num)) {
    // resultArray[0] = hs.get(target - num);
    // resultArray[1] = i;
    // return resultArray;
    // } else {
    // hs.put(num, i);
    // }
    // }

    // }

    public static void main(String[] args) {
        int arr[] = { 3, 3, };
        printArray(getTargetIndex(arr, 6));
    }
}
