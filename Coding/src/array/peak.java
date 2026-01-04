package array;

public class peak {

    public static int findPeakElement(int arr[], int start, int end) {
        int mid = (start + end) / 2;
        if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (arr[mid] > arr[mid - 1]) {
            return findPeakElement(arr, mid + 1, end);
        } else {
            return findPeakElement(arr, start, mid - 1);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 7, 8, 3 };
        // if(arr.length==2){
        // return arr[0]>arr[1]
        // }
        // int length = arr.length;
        // if (length == 1) {
        // return 0;
        // }
        // if (arr[0] > arr[1]) {
        // return 0;
        // }
        // if (arr[length - 1] > arr[length - 2]) {
        // return length - 1;
        // }
        System.out.println(findPeakElement(arr, 1, arr.length - 2));
    }

}
