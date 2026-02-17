package BackTrackingGFG.Medium;

import java.util.ArrayList;

public class iterativeSubSet {

    public static void findAllSubSet(int arr[], int currentIndex, ArrayList<Integer> result) {

        if (currentIndex >= arr.length) {
            System.out.println(result);
            return;
        }
        result.add(arr[currentIndex]);
        findAllSubSet(arr, currentIndex + 1, result);
        result.remove(result.size() - 1);
        findAllSubSet(arr, currentIndex + 1, result);
        return;

    }

    // public static void findAllSubSet(int arr[], int currentIndex,
    // ArrayList<Integer> result) {

    // System.out.println(result);

    // for (int i = currentIndex; i < arr.length; i++) {
    // result.add(arr[i]);
    // findAllSubSet(arr, i + 1, result);
    // result.remove(result.size() - 1);
    // }
    // }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        findAllSubSet(arr, 0, new ArrayList<>());

    }

}
