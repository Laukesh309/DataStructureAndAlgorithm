package HeapChapter;

import java.util.Comparator;
import java.util.PriorityQueue;

public class NSoldier {

    static class Soldier implements Comparable<Soldier> {
        int index;
        int count;

        Soldier(int index, int count) {
            this.index = index;
            this.count = count;
        }

        @Override

        public int compareTo(Soldier s2) {
            if (this.count != s2.count) {
                return this.count - s2.count;
            }
            return this.index - s2.index;
        }

    }

    public static void main(String[] args) {

        int arr[][] = { { 1, 0, 0, 0 }, { 1, 1, 1, 1 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 } };
        PriorityQueue<Soldier> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
            pq.add(new Soldier(i, count));
        }
        int k = 2;
        // while (!pq.isEmpty()) {
        // System.out.println(pq.peek().index + " " + pq.peek().count);
        // pq.remove();
        // }
        for (int i = 1; i <= k; i++) {
            Soldier data = pq.remove();
            System.out.println("row" + data.index + " " + data.count);
        }
    }

}
