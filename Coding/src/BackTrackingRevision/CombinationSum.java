package BackTrackingRevision;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void findTarget(int arr[], int currentIndex, int target, List<Integer> result,
            List<List<Integer>> finalResult) {
        if (target == 0) {
            ArrayList<Integer> tempResult = new ArrayList<>(result);
            finalResult.add(tempResult);
            return;
        }
        if (target < 0 || currentIndex >= arr.length) {
            return;
        }
        result.add(arr[currentIndex]);
        findTarget(arr, currentIndex, target - arr[currentIndex], result, finalResult);
        result.remove(result.size() - 1);
        findTarget(arr, currentIndex + 1, target, result, finalResult);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> finalResult = new ArrayList<>();
        findTarget(arr, 0, target, new ArrayList<>(), finalResult);
        System.out.println(finalResult);
    }

}
