package array;

import java.util.PriorityQueue;

public class priorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(10);
        pq.add(20);
        pq.add(15);
        pq.add(2);
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

}
