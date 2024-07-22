package array.GeekForGeek;

public class sort0and1and2 {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void sortArray(int arr[]) {
        int inititalPointer = 0;
        int midPointer = 0;
        int lastPointer = arr.length - 1;
        while (midPointer <= lastPointer) {
            while (inititalPointer < lastPointer && arr[inititalPointer] == 0) {
                inititalPointer++;
                midPointer++;
            }
            while (lastPointer > midPointer && arr[lastPointer] == 2) {
                lastPointer--;

            }

            if (midPointer <= lastPointer) {
                if (arr[midPointer] == 2) {
                    int tempLast = arr[midPointer];
                    arr[midPointer] = arr[lastPointer];
                    arr[lastPointer--] = tempLast;

                } else if (arr[midPointer] == 0) {
                    int temp = arr[midPointer];
                    arr[midPointer++] = arr[inititalPointer];
                    arr[inititalPointer++] = temp;

                } else {
                    midPointer++;
                }
            }

        }
        printArray(arr);
    }

    public static void main(String[] args) {
        // int arr[] = { 2, 0, 2, 1, 1, 0 };
        // int arr[] = { 0, 0, 0, 0 };
        // int arr[] = { 1, 1, 1, 1 };
        // int arr[] = { 2, 1, 1, 0, 1 };
        int arr[] = { 0, 0, 1, 2, 1, 0, 1, 2, 0 };
        // sortArray(arr);
    }

}
