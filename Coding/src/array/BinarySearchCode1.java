package array;

public class BinarySearchCode1 {

    public static int getValue(int arr[], int inititalPointer, int lastPointer, int targetValue) {
        if (inititalPointer > lastPointer) {
            return -1;
        }
        int midPointer = (inititalPointer + lastPointer) / 2;
        if (arr[midPointer] == targetValue) {
            return midPointer;
        }
        if (arr[midPointer] > targetValue) {
            return getValue(arr, inititalPointer, midPointer - 1, targetValue);
        } else {
            return getValue(arr, midPointer + 1, lastPointer, targetValue);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 9, 10 };
        System.out.println(getValue(arr, 0, arr.length - 1, 6));
    }

}
