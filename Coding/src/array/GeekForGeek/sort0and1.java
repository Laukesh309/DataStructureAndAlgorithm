package array.GeekForGeek;

public class sort0and1 {
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void sortZeroOne(int arr[]) {
        int inititalPointer = 0;
        int lastPointer = arr.length - 1;
        while (inititalPointer < lastPointer) {
            while (inititalPointer < arr.length && arr[inititalPointer] == 0) {
                inititalPointer++;
            }
            while (lastPointer >= 0 && arr[lastPointer] == 1) {
                lastPointer--;
            }
            if (inititalPointer < lastPointer) {
                int temp = arr[inititalPointer];
                arr[inititalPointer++] = arr[lastPointer];
                arr[lastPointer--] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // int arr[] = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
        // int arr[] = { 1, 1, 1, 1 };
        int arr[] = { 0, 0, 0, 0 };
        sortZeroOne(arr);
        printArray(arr);

    }

}
