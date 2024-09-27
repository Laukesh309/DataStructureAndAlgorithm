package recursion.recursionRevision;

public class checkGivenArraySorted {

    public static boolean isSorted(int arr[], int currentIndex) {
        if (currentIndex == 0) {
            return true;
        }
        if (arr[currentIndex] < arr[currentIndex - 1]) {
            return false;
        }
        return isSorted(arr, currentIndex - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 9, 5 };
        System.out.println(isSorted(arr, arr.length - 1));
    }

}
