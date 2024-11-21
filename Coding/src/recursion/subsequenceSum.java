package recursion;

import java.util.ArrayList;

public class subsequenceSum {

    public static boolean printAllSubSequnce(int arr[], int currentIndex, int k, int sum, ArrayList<Integer> result) {
        if (currentIndex >= arr.length) {
            if (sum == k) {
                System.out.println(result);
                // return 1;
                return true;
            } else {
                // return 0;
                return false;
            }
        }
        int currentElement = arr[currentIndex];
        result.add(currentElement);
        boolean left = printAllSubSequnce(arr, currentIndex + 1, k, sum + currentElement, result);
        result.remove(result.size() - 1);
        boolean right = left || printAllSubSequnce(arr, currentIndex + 1, k, sum, result);
        return right;
        // result.remove(result.size() - 1);
        // int right =
        // return left + right;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1 };
        System.out.println(printAllSubSequnce(arr, 0, 2, 0, new ArrayList<Integer>()));

    }

}
