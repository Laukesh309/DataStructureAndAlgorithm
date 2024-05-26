package HashMap;

import java.util.HashMap;

public class subArrayEqualToK {

    public static int findTotalSubArray(int arr[], int totalSum) {
        int result = 0;
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (hm.containsKey(sum - totalSum)) {
                result += hm.get(sum - totalSum);

            }
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 3 };
        // int totalSum = 3;
        int arr[] = { 10, 2, -2, -20, 10 };
        int totalSum = -10;
        System.out.println(findTotalSubArray(arr, totalSum));

    }

}
