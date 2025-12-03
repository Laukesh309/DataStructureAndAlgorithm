package GreedyAlgorithm;

import java.util.PriorityQueue;

public class NMeetingRoom {
    static class Pair implements Comparable<Pair> {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Pair p2) {
            return this.end - p2.end;
        }
    }

    public static int findMax(int start[], int end[]) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < start.length; i++) {
            pq.add(new Pair(start[i], end[i]));
        }
        int currentMaxTime = Integer.MIN_VALUE;
        int totalCount = 0;
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int cStart = pair.start;
            int cEnd = pair.end;
            if (cStart > currentMaxTime) {
                totalCount++;
                currentMaxTime = cEnd;
            }

        }
        System.out.println(totalCount);
        return totalCount;
    }

    public static void main(String[] args) {
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        findMax(start, end);
    }

}
