package ArrayRevision;

public class RoteteArray {

    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void rotateArray(int arr[], int k) {

        while (k > 0) {
            int prevValue = arr[0];
            for (int i = 1; i < arr.length; i++) {
                int currValue = arr[i];
                arr[i] = prevValue;
                prevValue = currValue;
            }
            arr[0] = prevValue;
            k--;
        }
        printArray(arr);
    }

    public static void rotatedArray(int arr[], int k) {
        int count = 0;
        int i = 0;
        while (count < arr.length) {
            count++;
            int prevValue = arr[i];
            int currentValue = (i + k) % arr.length;
            arr[(i + k) % arr.length] = prevValue;
            i = (i + k) % arr.length;
        }
    }

    public static void reverseArray(int arr[], int startingIndex, int endIndex) {
        if (endIndex < 0) {
            return;
        }
        while (startingIndex <= endIndex) {
            int temp = arr[startingIndex];
            arr[startingIndex++] = arr[endIndex];
            arr[endIndex--] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        // rotateArray(arr, k);
        k = reverseArray(arr, 0, arr.length - 1);
        printArray(arr);
        reverseArray(arr, 0, (k - 1));
        printArray(arr);
        reverseArray(arr, k, arr.length - 1);
        printArray(arr);
    }

}
