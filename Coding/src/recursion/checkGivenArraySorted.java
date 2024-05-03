package recursion;

public class checkGivenArraySorted {

    public static boolean findArraySorted(int arr[], int lastIndex) {

        if (lastIndex == 0) {
            return true;
        }
        if (arr[lastIndex] < arr[lastIndex - 1]) {
            return false;
        }
        return findArraySorted(arr, lastIndex - 1);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 5, 6, 7, 8, 9, 10, 11 };
        boolean isSorted = findArraySorted(arr, arr.length - 1);
        System.out.println(isSorted);
    }

}
