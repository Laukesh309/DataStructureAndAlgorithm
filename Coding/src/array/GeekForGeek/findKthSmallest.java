package array.GeekForGeek;

import java.util.PriorityQueue;

public class findKthSmallest {

    public static int findKthSmallest(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        for (int i = 1; i < k; i++) {
            pq.remove();
        }
        System.out.println(pq);
        int value = pq.peek();
        return value;
    }

    public static void main(String[] args) {
        // int arr[] = { 7, 10, 4, 3, 20, 15 };
        int arr[] = { 7, 10, 4, 20, 15 };
        int k = 4;
        System.out.println(findKthSmallest(arr, k));
    }

}
