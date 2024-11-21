package recursion;

import java.util.ArrayList;

public class subSet {

    public static void printAllSubSequence(int arr[], int currentIndex, ArrayList<Integer> result) {
        if (currentIndex >= arr.length) {
            System.out.println(result);
            return;
        }
        result.add(arr[currentIndex]);
        printAllSubSequence(arr, currentIndex + 1, result);
        result.remove(result.size() - 1);
        printAllSubSequence(arr, currentIndex + 1, result);

    }

    public static void main(String[] args) {
        int arr[] = { 4, 3, 5 };
        printAllSubSequence(arr, 0, new ArrayList<Integer>());
    }

}
