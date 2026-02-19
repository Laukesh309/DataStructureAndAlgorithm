package GfGGraph.Easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SnakeAndLadderProblem {

    static class Pair implements Comparable<Pair> {
        int source;
        int count;

        Pair(int source, int count) {
            this.source = source;
            this.count = count;
        }

        public int compareTo(Pair pair) {
            return this.count - pair.count;
        }

    }

    public static int findMinMov(HashMap<Integer, Integer> hm) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int source = pair.source;
            int count = pair.count;
            System.out.println(source + "   " + count);
            if (source == 30) {
                return count;
            }
            for (int i = 1; i < 7; i++) {
                int nextMove = source + i;
                if (hm.containsKey(nextMove)) {
                    nextMove = hm.get(nextMove);
                }
                if (nextMove <= 30) {
                    pq.add(new Pair(nextMove, count + 1));
                }

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int N = 3;

        int arr[] = { 21, 8, 13, 29, 16, 26 };
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int firstIndex = 2 * i;
            int secondIndex = 2 * i + 1;
            hm.put(arr[firstIndex], arr[secondIndex]);
        }
        System.out.println(hm);
        System.out.println(findMinMov(hm));
        // System.out.println(hm);

    }

}
