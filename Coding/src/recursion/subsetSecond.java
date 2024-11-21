package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class subsetSecond {

    public static void findSubSet(int arr[], int currentIndex, ArrayList<Integer> currentResult,
            List<List<Integer>> result) {

        if (currentIndex >= arr.length) {
            Collections.sort(currentResult);
            result.add(currentResult);

            return;
        }

        currentResult.add(arr[currentIndex]);
        findSubSet(arr, currentIndex + 1, new ArrayList<>(currentResult), result);
        currentResult.remove(currentResult.size() - 1);
        findSubSet(arr, currentIndex + 1, new ArrayList<>(currentResult), result);
        return;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 1, 1 };
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        findSubSet(arr, 0, new ArrayList<>(), result);
        HashSet<List<Integer>> setList = new HashSet<>(result);
        return new ArrayList<>(setList);

    }

}
