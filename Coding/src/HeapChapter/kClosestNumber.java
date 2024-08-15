package HeapChapter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class kClosestNumber {

    public class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public void findKClosestNumber(int arr[], int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((key1, key2) -> key2.key - key1.key);

        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int difference = Math.abs(x - arr[i]);
            Pair pr = new Pair(difference, i);
            pq.add(pr);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        while (!pq.isEmpty()) {
            System.out.println("key--> " + pq.peek().key + " value --> " + pq.peek().value);
            list1.add(pq.peek().value);
            pq.remove();
        }
        for (int i = 0; i < list1.size(); i++) {
            System.out.println("closedValue " + arr[list1.get(i)]);
        }
        System.out.println(list1);

    }

    public static void main(String[] args) {
        int arr[] = { 5, 6, 7, 8, 9 };
        int k = 3;
        int x = 7;
        kClosestNumber temp = new kClosestNumber();
        temp.findKClosestNumber(arr, k, x);
    }

}
