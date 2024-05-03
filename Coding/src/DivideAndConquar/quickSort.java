package DivideAndConquar;

public class quickSort {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int findPivotIndex(int arr[], int startIndex, int lastIndex) {
        int pivotElement = arr[lastIndex];
        int counter = startIndex - 1;
        for (int i = startIndex; i < lastIndex; i++) {
            if (arr[i] < pivotElement) {
                counter++;
                int temp = arr[i];
                arr[i] = arr[counter];
                arr[counter] = temp;
            }
        }
        counter++;
        int temp = arr[counter];
        arr[counter] = pivotElement;
        arr[lastIndex] = temp;
        return counter;
    }

    public static void quickSortImp(int arr[], int startIndex, int lastIndex) {
        if (startIndex >= lastIndex) {
            return;
        }
        int pivotIndex = findPivotIndex(arr, startIndex, lastIndex);
        quickSortImp(arr, startIndex, pivotIndex - 1);
        quickSortImp(arr, pivotIndex + 1, lastIndex);

    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 8, 2, 5 };
        quickSortImp(arr, 0, arr.length - 1);
        printArray(arr);

    }

}
