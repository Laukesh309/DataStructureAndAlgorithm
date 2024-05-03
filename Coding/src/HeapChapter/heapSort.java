package HeapChapter;

public class heapSort {
    static class Heap {

        public static void heapify(int arr[], int rootIndex, int lastIndex) {
            int maxIndex = rootIndex;
            int leftChild = 2 * rootIndex + 1;
            int rightChild = 2 * rootIndex + 2;
            if (leftChild < lastIndex && arr[maxIndex] < arr[leftChild]) {
                maxIndex = leftChild;
            }
            if (rightChild < lastIndex && arr[maxIndex] < arr[rightChild]) {
                maxIndex = rightChild;
            }
            if (maxIndex != rootIndex) {
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[rootIndex];
                arr[rootIndex] = temp;
                heapify(arr, maxIndex, lastIndex);
            }

        }

        public static void heapSortImp(int arr[]) {
            int length = arr.length;
            for (int i = arr.length / 2; i >= 0; i--) {
                heapify(arr, i, length);
            }
            /// sortArray
            for (int i = arr.length - 1; i >= 0; i--) {
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
                heapify(arr, 0, i);
            }
        }

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 4, 5, 3 };
        Heap.heapSortImp(arr);
        System.out.println(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
