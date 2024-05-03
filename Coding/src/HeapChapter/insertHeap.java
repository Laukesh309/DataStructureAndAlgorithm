package HeapChapter;

import java.util.ArrayList;

public class insertHeap {

    static class Heap {
        ArrayList<Integer> arrList = new ArrayList<>();

        public int peek() {
            return arrList.get(0);
        }

        public void add(int data) {
            arrList.add(data);
            int x = (arrList.size() - 1);
            int parentIndex = (x - 1) / 2;
            while (arrList.get(x) < arrList.get(parentIndex)) {
                int temp = arrList.get(x);
                arrList.set(x, arrList.get(parentIndex));
                arrList.set(parentIndex, temp);
                x = parentIndex;
                parentIndex = (parentIndex - 1) / 2;

            }
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        int arr[] = { 5, 3, 4, 2, 10 };
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

    }

}
