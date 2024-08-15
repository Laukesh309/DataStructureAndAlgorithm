package HeapChapter;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class topKelementFrequecy {

    public static void findElementFrequency(int arr[], int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                hm.put(arr[i], hm.get(arr[i]) + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
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
        int arr[] = { 1, 1, 1, 3, 3, 3, 3, 3, 3, 2, 2, 4 };
        int k = 3;
        findElementFrequency(arr, k);
    }

}
