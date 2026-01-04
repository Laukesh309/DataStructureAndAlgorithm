package array;

public class sortedMin {

    public static int findMinElemnt(int arr[], int start, int end) {
        if (arr[start] <= arr[end]) {
            return arr[start];
        }
        if (start == end) {
            return arr[start];
        }
        int mid = (start + end) / 2;
        if (arr[mid] >= arr[start]) {
            return findMinElemnt(arr, mid + 1, end);
        } else {
            return findMinElemnt(arr, start, mid);
        }

    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 3 };
        System.out.println(findMinElemnt(arr, 0, arr.length - 1));
    }

}
