package HeapChapter;

import java.util.ArrayList;

public class insertHeap1 {

    static class Heap {
        ArrayList<Integer> heap = new ArrayList<>();

        public void buildHead(int data) {
            heap.add(data);
            int childIndex = heap.size() - 1;
            int parentIndex = (childIndex - 1) / 2;
            while (heap.get(parentIndex) > heap.get(childIndex)) {
                int tempData = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(childIndex));
                heap.set(childIndex, tempData);
                childIndex = parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            }
        }

        public int peek() {
            return heap.get(0);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 8, 6, 10, 3, 15, 4 };
        Heap hp = new Heap();
        for (int i = 0; i < arr.length; i++) {
            hp.buildHead(arr[i]);
        }
        System.out.println(hp.heap);
        System.out.println(hp.peek());

    }
}
