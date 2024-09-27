package GreedyAlgorithm;

import java.util.PriorityQueue;

public class shortestJobFirst {

    public static int findAvg(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        int currentWait = 0;
        int totalWait = 0;
        for (int i = 1; i < arr.length; i++) {
            currentWait = currentWait + pq.remove();
            totalWait = totalWait + currentWait;
        }

        return totalWait / arr.length;

    }

    public static void main(String[] args) {
        int arr[] = { 4, 3, 7, 1, 2 };
        System.out.println(findAvg(arr));

    }

}
