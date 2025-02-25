package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum {

    public static void findAllCombination(int arr[], int target, int currentIndex, ArrayList<Integer> currentResult,
            HashSet<ArrayList<Integer>> finalResult) {
        if (target == 0) {
            Collections.sort(currentResult);
            ArrayList<Integer> result = new ArrayList<>(currentResult);
            finalResult.add(result);
            return;
        }
        if (currentIndex >= arr.length || target < 0) {
            return;
        }
        findAllCombination(arr, target, currentIndex + 1, currentResult, finalResult);
        if (arr[currentIndex] <= target) {
            currentResult.add(arr[currentIndex]);
            findAllCombination(arr, target - arr[currentIndex], currentIndex + 1, currentResult, finalResult);
            currentResult.remove(currentResult.size() - 1);
        }
    }

    public static void main(String[] args) {

        int arr[] = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        HashSet<ArrayList<Integer>> finalResult = new HashSet<>();
        findAllCombination(arr, target, 0, new ArrayList<>(), finalResult);
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> list : finalResult) {
            result.add(list);
        }
        System.out.println(result);

    }

}
