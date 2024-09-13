package Sheet.Array.medium;

import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array/description/

public class kthLargestNumber {

    public static int getKthLargestNumber(int arr[], int k) {
        PriorityQueue<Integer> result = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            result.add(arr[i]);
            if (result.size() > k) {
                result.poll();
            }
        }
        return result.peek();
    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;
        System.out.println(getKthLargestNumber(arr, k));
    }

}
