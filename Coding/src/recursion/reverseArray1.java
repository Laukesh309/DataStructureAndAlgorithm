package recursion;

public class reverseArray1 {

    public static void printArray(int arr[]) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void topToBottomReverse(int arr[], int start, int end) {

        if (start > end) {
            return;
        } else {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
            topToBottomReverse(arr, start, end);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 5, 6, 8 };
        topToBottomReverse(arr, 0, arr.length - 1);
        printArray(arr);
    }

}
