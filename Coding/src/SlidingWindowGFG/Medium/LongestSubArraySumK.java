package SlidingWindowGFG.Medium;

import java.util.HashMap;

public class LongestSubArraySumK {

    public static int findLongestSubArraySum(int arr[], int k) {
        int total = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            total = total + arr[i];
            if (hm.containsKey(total - k)) {
                maxLength = Math.max(maxLength, i - hm.get(total - k));
            }
            if (!hm.containsKey(total)) {
                hm.put(total, i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int arr[] = { 10, -10, 20, 30 };
        int k = 5;
        System.out.println(findLongestSubArraySum(arr, k));
    }

}
