package BackTrackingGFG.Easy;

import java.util.ArrayList;

public class EqualPartition {

    public static void findTotal(int arr[], int currentIndex, ArrayList<Integer> result, int target,
            ArrayList<ArrayList<Integer>> finalResult) {
        if (target == 0) {
            ArrayList<Integer> tempResult = new ArrayList<>(result);
            finalResult.add(tempResult);
            return;
        }
        if (target < 0 || currentIndex >= arr.length) {
            return;
        }
        result.add(arr[currentIndex]);
        findTotal(arr, currentIndex + 1, result, target - arr[currentIndex], finalResult);
        result.remove(result.size() - 1);
        findTotal(arr, currentIndex + 1, result, target, finalResult);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total = total + arr[i];
        }
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        findTotal(arr, 0, new ArrayList<>(), total / 2, finalResult);
        System.out.println(finalResult);

    }

}
