package HeapChapter;

import java.util.ArrayList;

public class DeleteHeap {

    static class Heap {
        ArrayList<Integer> heap = new ArrayList<>();

        public void add(int data) {
            heap.add(data);
            int currentIndex = heap.size() - 1;
            int parentIndex = (currentIndex - 1) / 2;
            while (heap.get(parentIndex) > heap.get(currentIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(currentIndex));
                heap.set(currentIndex, temp);
                currentIndex = parentIndex;
                parentIndex = (currentIndex - 1) / 2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public void heapify(int index) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int midIndex = index;
            if (leftChild < heap.size() && heap.get(midIndex) > heap.get(leftChild)) {
                midIndex = leftChild;
            }
            if (rightChild < heap.size() && heap.get(midIndex) > heap.get(rightChild)) {
                midIndex = rightChild;
            }
            if (midIndex != index) {
                int temp = heap.get(midIndex);
                heap.set(midIndex, heap.get(index));
                heap.set(index, temp);
                heapify(midIndex);
            }

        }

        public int remove() {
            int temp = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            heapify(0);
            return temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 5, 1, 6, 9, 4, 7 };
        Heap hp = new Heap();
        for (int i = 0; i < arr.length; i++) {
            hp.add(arr[i]);
        }
        while (!hp.heap.isEmpty()) {
            System.out.print(hp.peek() + " ");
            hp.remove();
        }
    }

}
