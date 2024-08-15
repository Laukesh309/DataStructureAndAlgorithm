package HeapChapter;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequenceSort {

    public static void frequencySort(int arr[]) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            pq.add(entry);
        }
        int counter = 0;
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> mp = pq.remove();
            int key = mp.getKey();
            int value = mp.getValue();
            for (int i = 1; i <= value; i++) {
                arr[counter++] = key;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] args) {
        int arr[] = { 5, 5, 1, 1, 1, 1, 3, 2, 2, 2, 4 };

        frequencySort(arr);
    }

}
