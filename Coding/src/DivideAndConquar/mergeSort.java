package DivideAndConquar;

public class mergeSort {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "==>");
        }
        System.out.println();
    }

    public static void merge(int arr[], int startIndex, int midIndex, int lastIndex) {
        int tempArray[] = new int[lastIndex - startIndex + 1];
        int firstPointer = startIndex;
        int secondPointer = midIndex + 1;
        int counter = 0;
        while (firstPointer <= midIndex && secondPointer <= lastIndex) {
            if (arr[firstPointer] < arr[secondPointer]) {
                tempArray[counter] = arr[firstPointer];
                firstPointer++;
            } else {
                tempArray[counter] = arr[secondPointer];
                secondPointer++;

            }
            counter++;
        }
        while (firstPointer <= midIndex) {
            tempArray[counter++] = arr[firstPointer++];
        }
        while (secondPointer <= lastIndex) {
            tempArray[counter++] = arr[secondPointer++];
        }
        counter = 0;
        for (int i = startIndex; i <= lastIndex; i++) {
            arr[i] = tempArray[counter++];
        }

    }

    public static void mergeSortImp(int arr[], int startIndex, int lastIndex) {
        if (startIndex >= lastIndex) {
            return;
        }
        int midIndex = (startIndex + lastIndex) / 2;
        mergeSortImp(arr, startIndex, midIndex);
        mergeSortImp(arr, midIndex + 1, lastIndex);
        merge(arr, startIndex, midIndex, lastIndex);
        printArray(arr);
    }

    public static void main(String[] args) {
        int arr[] = { 6, 3, 9, 5, 2, 8 };
        mergeSortImp(arr, 0, arr.length - 1);

    }

}
