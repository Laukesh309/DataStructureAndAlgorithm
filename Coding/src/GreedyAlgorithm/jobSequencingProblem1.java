package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

import top150InterviewProblem.Array.intergerToRoman;

public class jobSequencingProblem1 {

    static class Pair implements Comparable<Pair> {
        int deadline;
        int profit;

        Pair(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }

        public int compareTo(Pair p2) {
            return p2.profit - this.profit;
        }

    }

    public static int findParent(int parent[], int u) {
        if (parent[u] == u) {
            return u;
        }
        int tempParent = findParent(parent, parent[u]);
        parent[u] = tempParent;
        return tempParent;
    }

    public static void findUnioun(int parent[], int u, int v) {
        int uParent = findParent(parent, u);
        parent[v] = uParent;
        parent[u] = uParent;
    }

    public static void findMaxValue(int deadline[], int profit[]) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int maxDeadline = Integer.MIN_VALUE;
        for (int i = 0; i < deadline.length; i++) {
            maxDeadline = Math.max(maxDeadline, deadline[i]);
            pq.add(new Pair(deadline[i], profit[i]));
        }
        int parent[] = new int[maxDeadline + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int maxValue = 0;
        int totalCount = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int curDeadLine = pair.deadline;
            int curProfit = pair.profit;
            int availableSlot = findParent(parent, curDeadLine);
            if (availableSlot > 0) {
                totalCount++;
                maxValue = maxValue + curProfit;
                findUnioun(parent, availableSlot - 1, availableSlot);
            }
        }
        result.add(totalCount);
        result.add(maxValue);

        System.out.println(result);
    }

    public static void main(String[] args) {
        int deadline[] = { 11, 2, 5, 8, 11, 10, 1, 6, 3, 8, 10 };
        int profit[] = { 321, 62, 456, 394, 424, 22, 393, 87, 118, 384, 83 };
        findMaxValue(deadline, profit);
    }

}
