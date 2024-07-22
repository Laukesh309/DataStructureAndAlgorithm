package array.GeekForGeek;

import java.util.ArrayList;
// https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1

public class indexofSubArray {

    public static ArrayList<Integer> findIndexOfSubArray(int arr[], int s) {

        int start = 0;
        int end = 0;
        int sum = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        // while (start < arr.length && arr[start] > s) {
        // start++;
        // end++;
        // }
        while (end < arr.length) {

            if (sum + arr[end] < s) {
                sum += arr[end++];
            } else {
                sum -= arr[start++];
            }
            if (sum + arr[end] == s) {
                ans.add(start + 1);
                ans.add(end + 1);
                return ans;
            }
        }
        ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 7, 5 };
        int s = 12;
        // int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, n = 10, s = 15;
        // int arr[] = { 7, 2, 1 }, n = 3, s = 2;
        // int arr[] = { 5, 3, 4 }, n = 3, s = 2;
        // int arr[] = { 1, 2, 3, 4 }, s = 0;
        System.out.println(findIndexOfSubArray(arr, s));
    }

}
