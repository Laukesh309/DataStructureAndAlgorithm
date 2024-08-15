package array;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class kthLargestArray {

    public static int getLargestValue(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        for (int i = 1; i < k; i++) {
            pq.remove();
        }
        return pq.peek();

    }

    public static void main(String[] args) {
        // int arr[] = { 3, 2, 1, 5, 6, 4 };
        int arr[] = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };

        int k = 4;
        System.out.println(getLargestValue(arr, k));

    }

}
