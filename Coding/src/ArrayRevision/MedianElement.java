package ArrayRevision;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MedianElement {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianElement() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);

    }

    public void addNum(int num) {
        if (maxHeap.size() > minHeap.size()) {
            int peekElement = maxHeap.peek();
            if (num >= peekElement) {
                minHeap.add(num);
            } else {

                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }
        } else {
            if (minHeap.isEmpty()) {
                maxHeap.add(num);
            } else {
                int peekElement = minHeap.peek();
                if (peekElement >= num) {
                    maxHeap.add(num);
                } else {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                }
            }
        }

    }

    public double findMedian() {
        int totalSize = minHeap.size() + maxHeap.size();
        if (totalSize % 2 != 0) {
            return maxHeap.peek();
        } else {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        }

    }

    public static void main(String[] args) {
        MedianElement medianFinder = new MedianElement();
        medianFinder.addNum(-1); // arr = [1]
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2); // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) /
        // // 2)
        medianFinder.addNum(-3); // arr = [1, 2]
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4); // arr = [1, 2]
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5); // arr = [1, 2]
        System.out.println(medianFinder.findMedian());

    }

}
