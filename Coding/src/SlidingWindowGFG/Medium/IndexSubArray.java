package SlidingWindowGFG.Medium;

import java.util.ArrayList;
import java.util.HashMap;

public class IndexSubArray {

    public static ArrayList<Integer> findSubArray(int arr[], int target) {

        int currentSum = 0;
        int left = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            while (currentSum > target) {
                currentSum = currentSum - arr[left];
                left++;
            }
            if (currentSum == target) {
                result.add(left + 1);
                result.add(i + 1);
                return result;
            }
        }
        result.add(-1);
        return result;
    }

    public static ArrayList<Integer> findSubArrayPrefix(int arr[], int target) {
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 0);

        int currentum = 0;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            currentum = currentum + arr[i];
            if (prefix.containsKey(currentum - target)) {
                result.add(prefix.get(currentum - target) + 2);
                result.add(i + 1);
                return result;
            }
            if (!prefix.containsKey(currentum)) {
                prefix.put(currentum, i);
            }

        }
        result.add(-1);
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 3, 4 }, target = 2;
        System.out.println(findSubArray(arr, target));
        System.out.println(findSubArrayPrefix(arr, target));

    }

}
