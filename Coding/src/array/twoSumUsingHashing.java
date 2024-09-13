package array;

import java.util.ArrayList;
import java.util.HashMap;

public class twoSumUsingHashing {

    public static ArrayList<Integer> findSum(int arr[], int targetSum) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hs.containsKey(targetSum - arr[i])) {
                result.add(hs.get(targetSum - arr[i]));
                result.add(i);
                return result;
            }
            hs.put(arr[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 0, -1, 2, -3, 1 };
        int sum = -2;
        System.out.println(findSum(arr, sum));

    }

}
