package array.GeekForGeek;

import java.util.ArrayList;

public class twoSum {

    public static ArrayList<Integer> findIndex(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;

        ArrayList<Integer> result = new ArrayList<>();
        while (start < end) {
            if (arr[start] + arr[end] == target) {
                result.add(start + 1);
                result.add(end + 1);
            }
            if (arr[start] + arr[end] < target) {
                start = start + 1;
            } else {
                end = end - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { -1, 0 };
        int target = -1;
        System.out.println(findIndex(arr, target));

    }

}
