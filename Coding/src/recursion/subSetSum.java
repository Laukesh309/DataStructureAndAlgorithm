package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class subSetSum {

    public static void findAllSubSetSum(int arr[], int currentIndex, ArrayList<Integer> result, int currentSum) {
        if (currentIndex >= arr.length) {
            result.add(currentSum);
            return;
        }
        findAllSubSetSum(arr, currentIndex + 1, result, currentSum + arr[currentIndex]);
        findAllSubSetSum(arr, currentIndex + 1, result, currentSum);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3 };
        ArrayList<Integer> result = new ArrayList<>();
        findAllSubSetSum(arr, 0, result, 0);
        Collections.sort(result);
        System.out.println(result);

    }

}
