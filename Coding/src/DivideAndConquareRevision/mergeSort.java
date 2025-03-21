package DivideAndConquareRevision;

public class mergeSort {

    public static void merge(int arr[], int start, int mid, int last) {
        int temp[] = new int[last - start + 1];
        int firstPointer = start;
        int secondPointer = mid + 1;
        int currentInedex = 0;
        while (firstPointer <= mid && secondPointer <= last) {
            if (arr[firstPointer] <= arr[secondPointer]) {
                temp[currentInedex++] = arr[firstPointer++];
            } else {
                temp[currentInedex++] = arr[secondPointer++];
            }

        }
        while (firstPointer <= mid) {
            temp[currentInedex++] = arr[firstPointer++];
        }
        while (secondPointer <= last) {
            temp[currentInedex++] = arr[secondPointer++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[start++] = temp[i];
        }
        return;
    }

    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + "->");
        }
        System.out.print("end");
        System.out.println();
    }

    public static void mergeSort(int arr[], int first, int last) {
        if (first >= last) {
            return;
        }
        int mid = (first + last) / 2;
        mergeSort(arr, first, mid);
        mergeSort(arr, mid + 1, last);
        merge(arr, first, mid, last);

    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        printArray(arr);
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);

    }
}
