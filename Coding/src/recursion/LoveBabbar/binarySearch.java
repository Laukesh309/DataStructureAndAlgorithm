package recursion.LoveBabbar;

public class binarySearch {
    public static boolean searchValue(int arr[], int startIndex, int lastIndex, int key) {
        if (startIndex > lastIndex) {
            return false;
        }
        int midIndex = (startIndex + lastIndex) / 2;
        if (arr[midIndex] == key) {
            return true;
        }
        if (key > arr[midIndex]) {
            return searchValue(arr, midIndex + 1, lastIndex, key);
        } else {
            return searchValue(arr, startIndex, midIndex - 1, key);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 10, 15, 30, 40 };
        int key = 5;
        System.out.println(searchValue(arr, 0, arr.length - 1, key));
    }

}
