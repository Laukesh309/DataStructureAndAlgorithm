package BackTrackingGFG.Medium;

import java.util.ArrayList;

public class KSubset {

    public static boolean findKthSubSet(int arr[], int k, int target, int currentSum, boolean use[]) {
        if (k == 1) {
            return true;
        }
        if (currentSum == target) {
            return findKthSubSet(arr, k - 1, target, 0, use);
        }
        for (int i = 0; i < arr.length; i++) {
            if (use[i] == true || currentSum + arr[i] > target) {
                continue;
            } else {
                use[i] = true;
                if (findKthSubSet(arr, k, target, target - currentSum, use)) {
                    return true;
                }
                use[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 5, 6 };
        int k = 3;
        boolean use[] = new boolean[arr.length];
        int target = 0;
        for (int i = 0; i < arr.length; i++) {
            target += arr[i];
        }
        if (target % k != 0) {
            System.out.println("false");
            return;
        }
        System.out.println(findKthSubSet(arr, k, target / k, 0, use));
    }

}
