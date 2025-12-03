package ArrayRevision;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {

    static class Pair {
        int profit;
        int capital;

        Pair(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

    }

    public static void main(String[] args) {
        int k = 3;
        int w = 0;
        int profit[] = { 1, 2, 3 };
        int capital[] = { 0, 1, 2 };
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.capital - b.capital);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.profit - a.profit);
        for (int i = 0; i < profit.length; i++) {
            minHeap.add(new Pair(profit[i], capital[i]));
        }
        int totalProfit = 0;
        while (k > 0) {
            while (!minHeap.isEmpty() && minHeap.peek().capital <= w) {
                Pair newPair = minHeap.poll();
                maxHeap.add(new Pair(newPair.profit, newPair.capital));
            }
            w = w + maxHeap.poll().profit;
            k--;
        }
        System.out.println(w);
    }

}
