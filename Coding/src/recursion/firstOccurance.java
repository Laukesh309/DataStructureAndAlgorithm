package recursion;

public class firstOccurance {
    public static int findIndex(int arr[], int index, int key) {
        if (index == arr.length) {
            return -1;
        }
        if (arr[index] == key) {
            return index;
        }
        return findIndex(arr, index + 1, key);

    }

    public static void main(String[] args) {
        int arr[] = { 8, 3, 6, 9, 8, 10, 2, 5, 3 };
        int key = 100;
        int index = findIndex(arr, 0, key);
        if (index == -1) {
            System.out.println("NotFound");
        } else {
            System.out.println("Found At Index-->" + index);
        }
    }

}
