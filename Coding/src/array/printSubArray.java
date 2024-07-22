package array;

public class printSubArray {

    // public static void printSubArray(int arr[]) {

    // for (int i = 0; i < arr.length; i++) {
    // String result = "" + arr[i];
    // System.out.println(result);
    // for (int j = i + 1; j < arr.length; j++) {
    // result += arr[j];
    // System.out.println(result);
    // }
    // }
    // }

    public static void printSubArray(int arr[], int currentIndex) {
        if (currentIndex >= arr.length) {
            return;
        }

        String result = "";
        for (int i = currentIndex; i < arr.length; i++) {
            result += arr[i];
            System.out.println(result);
        }
        printSubArray(arr, currentIndex + 1);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 10 };
        // printSubArray(arr, 0);

    }

}
