package recursion.LoveBabbar;

public class quickSort {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "=>");
        }
        System.out.println();
    }

    public static int findPivotIndex(int arr[], int pivotElement, int pivotIndex) {
        for (int i = pivotIndex + 1; i < arr.length; i++) {
            if (arr[i] < pivotElement) {
                arr[pivotIndex] = arr[i];
                arr[i] = arr[pivotIndex + 1];
                pivotIndex++;
            }
        }
        arr[pivotIndex] = pivotElement;
        return pivotIndex;
    }

    public static void quickSortImp(int arr[], int startIndex, int lastIndex) {
        if (startIndex >= lastIndex) {
            return;
        }
        int pivotElement = arr[startIndex];
        int pivotIndex = findPivotIndex(arr, pivotElement, startIndex);
        quickSortImp(arr, startIndex, pivotIndex - 1);
        quickSortImp(arr, pivotIndex + 1, lastIndex);
        printArray(arr);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 1, 8, 2, 4, 8, 10, 19 };
        quickSortImp(arr, 0, arr.length - 1);
    }

}
