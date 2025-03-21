package DivideAndConquareRevision;

public class quickSort {

    public static void quickSort(int arr[], int start, int last) {
        if (start >= last) {
            return;
        }
        int pivot = arr[last];
        int firstPointer = start;
        int lastPointer = last - 1;
        while (firstPointer <= lastPointer) {
            while (firstPointer <= lastPointer && arr[firstPointer] <= pivot) {
                firstPointer++;
            }
            while (lastPointer >= firstPointer && arr[lastPointer] >= pivot) {
                lastPointer--;
            }
            if (firstPointer < lastPointer) {
                int temp = arr[firstPointer];
                arr[firstPointer++] = arr[lastPointer];
                arr[lastPointer--] = temp;
            }
        }
        int temp = arr[lastPointer + 1];
        arr[lastPointer + 1] = pivot;
        arr[last] = temp;
        printArray(arr);

        quickSort(arr, start, lastPointer);

        quickSort(arr, firstPointer + 1, last);

    }

    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 3, 3, 3, 3, 7, 3, 2, 2, 7 };
        // printArray(arr);
        quickSort(arr, 0, arr.length - 1);
        // printArray(arr);

    }

}
