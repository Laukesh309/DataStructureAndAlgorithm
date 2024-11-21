package recursion;

import java.util.ArrayList;
import java.util.List;

public class combinationSum {

    public static void printAllCombination(int arr[], int currentIndex, int target,
            ArrayList<Integer> result,
            int currentSum, List<List<Integer>> mainResult) {
        if (currentSum == target) {
            // System.out.println("this is target");
            ArrayList tempList = new ArrayList<>(result);
            mainResult.add(tempList);
            return;

        }
        if (currentIndex >= arr.length || currentSum > target) {
            return;
        }
        int currentElement = arr[currentIndex];
        result.add(currentElement);
        printAllCombination(arr, currentIndex, target, result,
                currentSum + currentElement, mainResult);
        result.remove(result.size() - 1);
        printAllCombination(arr, currentIndex + 1, target, result, currentSum, mainResult);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 6, 7 };
        List<List<Integer>> mainResult = new ArrayList<List<Integer>>();
        printAllCombination(arr, 0, 7, new ArrayList<>(), 0, mainResult);
        System.out.println(mainResult);

    }

}
