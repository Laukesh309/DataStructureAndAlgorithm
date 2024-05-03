package HashMap;

import java.util.HashMap;

public class subArraySumInteger {

    public static int getCount(int arr[], int key) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int result = 0;
        int sum = 0;
        hm.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (hm.containsKey(sum - key)) {
                result += hm.get(sum - key);
            }
            hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1)
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        int key = 3;

        System.out.println(getCount(arr, key));
    }

}
