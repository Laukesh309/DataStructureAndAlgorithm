package array.GeekForGeek;

public class findMinInSortedAndRotated {

    public static int minElement(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;
        while (start < end) {
            if (arr[mid] < arr[end]) {
                end = mid;
            } else {
                start = start + 1;
            }
            mid = (start + end) / 2;
        }

        return arr[start];

    }

    public static void main(String[] args) {
        // int arr[] = { 4, 5, 1, 2, 3 };
        // int arr[] = { 10, 20, 30, 40, 50, 5, 7 };
        int arr[] = { 1, 2, 3 };
        System.out.println(minElement(arr));
    }

}
