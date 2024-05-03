package recursion.LoveBabbar;

public class sort0and1and2 {

    public static void swapElement(int arr[], int firstIndex, int lastIndex) {
        int temp = arr[lastIndex];
        arr[lastIndex] = arr[firstIndex];
        arr[firstIndex] = temp;
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sortzeroandone(int arr[]) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while (mid < high) {
            if (arr[mid] == 0) {
                swapElement(arr, low, mid);
                low++;
                mid++;
            }
            if (arr[mid] == 2) {
                swapElement(arr, mid, high);
                high--;
            }
            if (arr[mid] == 1) {
                mid++;
            }
        }
        printArray(arr);

    }

    public static void main(String[] args) {
        int arr[] = { 0, 0, 0, 1, 1, 1, 0, 0, 2, 2, 2, 1, 1, 1, 0 };
        sortzeroandone(arr);
    }

}
