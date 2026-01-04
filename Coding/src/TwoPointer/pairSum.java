package TwoPointer;

import java.util.HashSet;

public class pairSum {

    public static boolean pairPossible(int arr[], int target) {
        HashSet<Integer> tempResult = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int searchElement = target - arr[i];
            if (tempResult.contains(searchElement)) {
                return true;
            } else {
                tempResult.add(arr[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 0, -1, 2, -3, 1 };
        int target = -2;
    }

}
