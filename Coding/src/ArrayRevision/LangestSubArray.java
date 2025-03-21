package ArrayRevision;

import java.util.HashMap;

public class LangestSubArray {

    public static int findLangest(int arr[], int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int prefixSum = 0;
        int count = 0;
        hm.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            int currentSum = prefixSum + arr[i];
            int prefix = currentSum - target;
            if (hm.containsKey(prefix)) {
                count = Math.max(count, i - hm.get(prefix));
            }
            if (!hm.containsKey(currentSum)) {
                hm.put(currentSum, i);
            }
            prefixSum = currentSum;
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 10, -10, 20, 30 };
        int k = 5;
        System.out.println(findLangest(arr, k));

    }

}
