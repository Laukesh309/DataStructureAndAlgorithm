package HeapChapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class kthElement {

    public static Object[] findKthSmallest(int arr[], int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        System.out.println(pq);
        Object arr1[] = pq.toArray();
        return arr1;

    }

    public static void findKLargestElement(int arr[], int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        System.out.println(pq);

    }

    public static void findKSortedArray(int arr[], int k) {
        ArrayList<Integer> list1 = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                list1.add(pq.remove());
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }

    public static void main(String[] args) {
        int arr[] = { 7, 10, 4, 3, 20, 15 };
        int k = 3;
        // Object[] data = findKthSmallest(arr, k);
        // for (Object item : data) {
        // System.out.println(item);
        // }
        // findKLargestElement(arr, k);
        findKSortedArray(arr, k);

    }

}
