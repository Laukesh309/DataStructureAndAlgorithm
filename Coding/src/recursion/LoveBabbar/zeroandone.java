package recursion.LoveBabbar;

public class zeroandone {

    public static void sortZeroAndOne(int arr[]) {
        int inititalPointer = 0;
        int lastPointer = arr.length - 1;
        while (inititalPointer < lastPointer) {
            while (arr[inititalPointer] == 0) {
                inititalPointer++;
            }
            while (arr[lastPointer] == 1) {
                lastPointer--;
            }
            if (inititalPointer < lastPointer) {
                arr[inititalPointer] = 0;
                arr[lastPointer] = 1;
                inititalPointer++;
                lastPointer--;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 0, 0, 1, 1, 0, 0, 1, 0 };
        sortZeroAndOne(arr);

    }

}
