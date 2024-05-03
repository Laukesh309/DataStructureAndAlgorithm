package HeapChapter;

import java.util.ArrayList;

public class DeleteHeap1 {

    static class Heap {
        ArrayList<Integer> heap = new ArrayList<>();

        public void buildHeap(int data) {
            heap.add(data);
            int childIndex = heap.size() - 1;
            int parentIndex = (childIndex - 1) / 2;
            while (heap.get(parentIndex) > heap.get(childIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, temp);
                childIndex = parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            }
        }

        public void heapify(int rootIndex) {
            int minInex = rootIndex;
            int leftChild = 2 * rootIndex + 1;
            int rightChild = 2 * rootIndex + 2;

            if (leftChild < heap.size() && heap.get(leftChild) > heap.get(minInex)) {
                minInex = leftChild;
            }
            if (rightChild < heap.size() && heap.get(rightChild) > heap.get(minInex)) {
                minInex = rightChild;
            }
            if (minInex != rootIndex) {
                int tempData = heap.get(rootIndex);
                heap.set(rootIndex, heap.get(minInex));
                heap.set(minInex, tempData);
                heapify(minInex);
            }

        }

        public int remove() {
            int data = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            heap.set(heap.size() - 1, data);
            int removedData = heap.remove(heap.size() - 1);
            heapify(0);
            return removedData;
        }

        public void convertMaxHeap() {
            int nonLeafNode = (heap.size()) / 2;
            for (int i = nonLeafNode; i >= 0; i--) {
                heapify(i);
            }

        }
    }

    public static void main(String[] args) {
        int arr[] = { 10, 16, 8, 20, 4, 50, 3 };
        Heap hp = new Heap();

        for (int i = 0; i < arr.length; i++) {
            hp.buildHeap(arr[i]);
        }
        System.out.println(hp.heap);
        // System.out.println(hp.remove());
        System.out.println(hp.heap);
        hp.convertMaxHeap();
        System.out.println(hp.heap);
    }

}
