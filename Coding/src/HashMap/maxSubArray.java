package HashMap;

import java.util.HashMap;

public class maxSubArray {

    public static int getMaxSubArray(int arr[]) {
        HashMap<Integer, Integer> datatable = new HashMap<>();
        int result = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum == 0) {
                result = i + 1;
            } else if (datatable.containsKey(sum)) {
                int prevIndex = datatable.get(sum);
                int resultIndex = i - prevIndex;
                result = Math.max(result, resultIndex);
            } else {
                datatable.put(sum, i);
            }
        }
        System.out.println(datatable);
        return result;

    }

    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10 };
        int arr2[] = { 3, 4, 5 };
        int arr3[] = { 3, 4, 5, -4, -3, -5 };

        System.out.println(getMaxSubArray(arr));
    }

}
