package BackTrackingGFG.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CombinationSumSecond {

    public static void findCombination(int candidates[], int currentIndex, ArrayList<Integer> currentResult,
            ArrayList<ArrayList<Integer>> finalResult, int target) {

        System.out.println("currentIndex++ " + currentIndex);
        if (target == 0) {
            ArrayList<Integer> tempResult = new ArrayList<>(currentResult);
            finalResult.add(tempResult);
            return;
        }
        if (currentIndex >= candidates.length || target < 0) {
            return;
        }
        // take
        currentResult.add(candidates[currentIndex]);
        findCombination(candidates, currentIndex + 1, currentResult, finalResult, target - candidates[currentIndex]);

        while (currentIndex + 1 < candidates.length && candidates[currentIndex] == candidates[currentIndex + 1]) {
            currentIndex++;
        }
        currentResult.remove(currentResult.size() - 1);
        findCombination(candidates, currentIndex + 1, currentResult, finalResult, target);

        return;
    }

    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int candidates[] = { 2, 5, 2, 1, 2 };
        int target = 5;
        Arrays.sort(candidates);
        // printArray(candidates);
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();

        findCombination(candidates, 0, new ArrayList<>(), finalResult, target);
        System.out.println(finalResult);
    }

}
