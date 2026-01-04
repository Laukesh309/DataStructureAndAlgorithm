package TwoPointer;

public class sortZeroOneTwo {

    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sortArray(int arr[]) {
        int firstPointer = 0;
        int lastPointer = arr.length - 1;
        int secondPointer = 0;
        while (secondPointer <= lastPointer) {
            while (arr[lastPointer] == 2) {
                lastPointer--;
            }
            while (arr[secondPointer] == 1) {
                secondPointer++;
            }
            if (arr[secondPointer] == 2) {
                arr[secondPointer] = arr[lastPointer];
                arr[lastPointer--] = 2;
            }
            if (arr[secondPointer] == 0) {
                int temp = arr[firstPointer];
                arr[firstPointer++] = arr[secondPointer];
                arr[secondPointer++] = temp;
            }
        }
        printArray(arr);
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 2, 0, 1, 2 };
        sortArray(arr);

    }

}
