package HeapChapter;

import java.util.Collections;
import java.util.PriorityQueue;

public class sumOfNumberbetweenKthSmallest {

    public static int findKthSmallest(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();

    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 12, 5, 15, 11 };
        int k1 = 3;
        int k2 = 6;
        int firstSmallest = findKthSmallest(arr, k1);
        int secondSmallest = findKthSmallest(arr, k2);
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstSmallest && arr[i] < secondSmallest) {
                totalSum += arr[i];
            }
        }
        System.out.println(totalSum);
    }

}
