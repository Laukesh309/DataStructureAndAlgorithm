package array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class slidingMaxWindow {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] findMaxWindowValue(int nums[], int k) {
        int start = 0;
        int end = 0;
        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (end < nums.length) {
            pq.add(nums[end]);
            if (end - start + 1 < k) {
                end++;
            } else {
                int peedElement = pq.peek();
                result.add(peedElement);
                pq.remove(nums[start]);
                start++;
                end++;
            }

        }
        System.out.println(result);
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < finalResult.length; i++) {
            finalResult[i] = result.get(i);
        }

        return finalResult;
    }

    public static void main(String[] args) {
        // int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        // int nums[] = { 9, 10, 9, -7, -4, -8, 2, -6 };
        int nums[] = { 1 };
        int k = 1;
        findMaxWindowValue(nums, k);
    }

}
