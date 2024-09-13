package Sheet.Array.Easy;

import java.util.ArrayList;

public class reverseSubArray {

    public static ArrayList<Integer> reverseSubArrayTwoPointer(int arr[], int start, int end) {
        ArrayList<Integer> result = new ArrayList<>();
        while (start <= end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
        }

        for (Integer integer : result) {
            System.out.println("this is laukesh");
        }
        return result;

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int start = 1;
        int end = 3;
        System.out.println(reverseSubArrayTwoPointer(arr, start, end));
    }

}
