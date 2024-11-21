package recursion;

import java.util.ArrayList;
import java.util.List;

public class permutation {

    public static void fintAllPermutation(int currentIndex, int arr[], ArrayList<Integer> currentResult,
            List<List<Integer>> finalResult) {
        if (currentIndex > arr.length - 1) {
            finalResult.add(currentResult);
            return;
        }
        for (int i = currentIndex; i < arr.length; i++) {
            int temp = arr[currentIndex];
            arr[currentIndex] = arr[i];
            arr[i] = temp;
            currentResult.add(arr[currentIndex]);
            fintAllPermutation(currentIndex + 1, arr, new ArrayList<>(currentResult), finalResult);
            arr[i] = arr[currentIndex];
            arr[currentIndex] = temp;
            currentResult.remove(currentResult.size() - 1);

        }
    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3 };
        List<List<Integer>> finalResult = new ArrayList<>();
        fintAllPermutation(0, arr, new ArrayList<>(), finalResult);
        System.out.println(finalResult);

    }

}
