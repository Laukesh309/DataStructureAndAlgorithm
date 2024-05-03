package recursion.LoveBabbar;

public class isSorted {
    public static boolean isSortedProb(int index, int arr[]) {
        if (index == (arr.length - 1)) {
            return true;
        }
        if (arr[index] > arr[index + 1]) {
            return false;
        }
        return isSortedProb(index + 1, arr);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 9, 11, 13, 0 };
        boolean isSortedValue = isSortedProb(0, arr);
        System.out.println(isSortedValue);
    }
}
