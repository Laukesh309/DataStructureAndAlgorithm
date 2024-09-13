package top150InterviewProblem.HashMap;

import java.util.HashMap;

public class containDublicate {

    public static boolean findContained(int arr[], int k) {
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hs.containsKey(arr[i])) {
                int secondIndex = hs.get(arr[i]);
                if (Math.abs(i - secondIndex) <= k) {
                    return true;
                }

            }
            hs.put(arr[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 1, 2, 3 };
        int k = 2;
        System.out.println(findContained(nums, k));
    }

}
