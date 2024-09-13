package BinarySearch;

public class totalTimesRotation {

    public static int findPivotElement(int arr[], int start, int end) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (arr[mid] >= arr[0]) {
            return findPivotElement(arr, mid + 1, end);
        } else {
            return findPivotElement(arr, start, mid);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 8, 11, 12, 15, 18, 2, 5, 7 };
        int pivotElement = findPivotElement(arr, 0, arr.length - 1);
        System.out.println(pivotElement);
        System.out.println("totalRotation++ ==" + (arr.length - pivotElement));
    }

}
