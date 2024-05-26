package HashMap;

import java.util.HashMap;

public class MaxSubArrayZeroSum {

    public static int findMaximumSubarray(int arr[]) {
        int result = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hm.containsKey(sum)) {
                result = Math.max(result, i - hm.get(sum));
            } else {
                hm.put(sum, i);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10 };
        System.out.println(findMaximumSubarray(arr));
    }

}
