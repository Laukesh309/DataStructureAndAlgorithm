package HeapChapter;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class kclosestToOrigin {

    public static void findKClosestElementToRoot(int arr[][], int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int distance = (int) (Math.pow(arr[i][0], 2) + Math.pow(arr[i][1], 2));
            hm.put(i, distance);
        }
        System.out.println(hm);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        int counter = 0;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            pq.add(entry);
            counter++;
            if (counter > k) {
                pq.remove();
            }
        }
        System.out.println(pq);

    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 3 }, { -2, 2 }, { 5, 8 }, { 0, 1 } };
        int k = 2;
        findKClosestElementToRoot(arr, k);
    }

}
