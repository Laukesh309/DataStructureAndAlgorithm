package DivideAndConquar;

public class mergeSortR1 {

    public static void mergeSortUtility(int arr[], int initialIndex, int mid, int lastIndex) {
        int temp[] = new int[lastIndex - initialIndex + 1];
        int firstCounter = initialIndex;
        int secondCounter = mid + 1;
        int i = 0;
        while (firstCounter <= mid && secondCounter <= lastIndex) {
            if (arr[firstCounter] <= arr[secondCounter]) {
                temp[i++] = arr[firstCounter++];
            } else {
                temp[i++] = arr[secondCounter++];
            }
        }
        while (firstCounter <= mid) {
            temp[i++] = arr[firstCounter++];
        }
        while (secondCounter <= lastIndex) {
            temp[i++] = arr[secondCounter++];
        }
        i = 0;
        for (int j = initialIndex; j <= lastIndex; j++) {
            arr[j] = temp[i++];
        }
    }

    public static void mergeSort(int arr[], int inititalIndex, int lastIndex) {
        if (inititalIndex >= lastIndex) {
            return;
        }
        int mid = (inititalIndex + lastIndex) / 2;
        mergeSort(arr, inititalIndex, mid);
        mergeSort(arr, mid + 1, lastIndex);
        mergeSortUtility(arr, inititalIndex, mid, lastIndex);
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

}
