package Sheet.Array.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class choclateDistribution {

    public static int findMinAndMaxDiff(int arr[], int totalStudent) {
        Arrays.sort(arr);
        int result = Integer.MAX_VALUE;
        int start = 0;
        int last = 0;
        while (last < arr.length) {
            if (last >= totalStudent - 1) {
                int Difference = arr[last] - arr[start];
                result = Math.min(result, Difference);
                start++;

            }
            last++;
        }
        return result;
    }

    // public static int findMinMax(int arr[], int totalStudent) {

    // }
    public long findMinDiff(ArrayList<Integer> arr, int n, int totalStudent) {
        Collections.sort(arr);
        int result = Integer.MAX_VALUE;
        int start = 0;
        int last = 0;
        while (last < arr.size()) {
            if (last >= totalStudent - 1) {
                int Difference = arr.get(last) - arr.get(start);
                result = Math.min(result, Difference);
                start++;

            }
            last++;
        }
        return result;
        // your code here
    }

    public static void main(String[] args) {
        int arr[] = { 7, 3, 2, 4, 9, 12, 56 };
        int totalStudent = 3;
        System.out.println(findMinAndMaxDiff(arr, totalStudent));
    }

}
