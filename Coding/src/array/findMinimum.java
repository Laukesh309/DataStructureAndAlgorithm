package array;

public class findMinimum {

    public static int findMinimum(int arr[]) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return arr[start];
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 1, 2 };
        // int arr[] = { 11, 13, 15, 17 };
        // int arr[] = { 3, 1, 2 };
        System.out.println(findMinimum(arr));
    }

}
