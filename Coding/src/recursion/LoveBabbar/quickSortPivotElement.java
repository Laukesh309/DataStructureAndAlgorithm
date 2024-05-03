package recursion.LoveBabbar;

public class quickSortPivotElement {

    public static int findPivotIndex(int arr[], int element, int startIndex, int lastIndex) {
        int count = 0;
        for (int i = startIndex; i <= lastIndex; i++) {
            if (element > arr[i]) {
                count++;
            }
        }
        return count;
    }

    public static void quickSort(int arr[], int startIndex, int lastIndex) {
        int pivotElement = arr[startIndex];
        int findPosition = findPivotIndex(arr, pivotElement, startIndex, lastIndex);
        int tempValue = arr[findPosition];
        arr[findPosition] = pivotElement;
        arr[startIndex] = tempValue;

    }

    public static void main(String[] args) {
        int arr[] = { 4, 1, 3, 5, 2 };

    }

}
