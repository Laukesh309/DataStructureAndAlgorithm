package recursion;

public class findKeyOccurance {

    public static void printAllOccrance(int arr[], int index, int key) {
        if (index >= arr.length) {
            return;
        }
        if (arr[index] == key) {
            System.out.println(index);
        }
        printAllOccrance(arr, index + 1, key);
    }

    public static int printSumOfAllOccurance(int arr[], int index, int key, int totalSum) {
        if (index >= arr.length) {
            return totalSum;
        }
        if (arr[index] == key) {
            totalSum = totalSum + key;
        }
        return printSumOfAllOccurance(arr, index + 1, key, totalSum);

    }

    public static void main(String[] args) {
        int arr[] = { 3, 2, 4, 2, 3, 5, 6, 2, 7, 5 };
        int key = 2;
        // printAllOccrance(arr, 0, key);
        System.out.println(printSumOfAllOccurance(arr, 0, key, 0));
        return;
    }

}
