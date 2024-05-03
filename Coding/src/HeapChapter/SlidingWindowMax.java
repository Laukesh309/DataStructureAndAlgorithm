package HeapChapter;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class SlidingWindowMax {

    static class Window implements Comparable<Window> {
        int index;
        int data;

        Window(int index, int data) {
            this.index = index;
            this.data = data;
        }

        public int compareTo(Window w2) {
            return w2.data - this.data;
        }
    }

    public static void main(String[] args) {
        // int num[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int num[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        PriorityQueue<Window> pq = new PriorityQueue<>();
        int k = 3;
        for (int i = 0; i < num.length; i++) {
            pq.add(new Window(i, num[i]));
            if (i >= k - 1) {
                Window peakElement = pq.peek();
                while (peakElement.index <= i - k) {
                    pq.remove();
                }
                System.out.println(pq.peek().data);

            }

        }

    }
}
