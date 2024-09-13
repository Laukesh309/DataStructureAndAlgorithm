package array.GeekForGeek;

import java.util.ArrayList;

public class findPair {

    public static String findIndex(int arr[], int target, int start, int end) {
        if (start >= end) {
            return "-1";
        }
        if (arr[start] + arr[end] == target) {
            return start + " " + end;
        }
        if (arr[start] + arr[end] > target) {
            return findIndex(arr, target, start, end - 1);
        } else {
            return findIndex(arr, target, start + 1, end);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 35, 50, 75, 80 };
        int target = 135;
        System.out.println(findIndex(arr, target, 0, arr.length - 1));
    }

}
