package DivideAndConquar;

public class QuickSortR1 {

    public static int findPivotIndex(int arr[], int firstIndex, int lastIndex) {
        int pivotElement = arr[firstIndex];
        int pivotIndex = firstIndex;
        for (int i = firstIndex; i <= lastIndex; i++) {
            if (arr[i] < pivotElement) {
                arr[pivotIndex] = arr[i];
                pivotIndex++;
                arr[i] = arr[pivotIndex];
            }
        }
        arr[pivotIndex] = pivotElement;
        return pivotIndex;
    }

    public static void QuickSortR1(int arr[], int initialPointer, int lastPointer) {
        if (initialPointer >= lastPointer) {
            return;
        }
        int pivotIndex = findPivotIndex(arr, initialPointer, lastPointer);
        QuickSortR1(arr, initialPointer, pivotIndex - 1);
        QuickSortR1(arr, pivotIndex + 1, lastPointer);

    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8, 0, 1, 17, 26, -5 };
        // int arr[] = { 6, 3, 9, 5 };
        QuickSortR1(arr, 0, arr.length - 1);
        printArray(arr);
    }

}
