package recursion;

public class lastOccurance {

    public static int findLastOccurence(int arr[], int index, int key) {
        if (index < 0) {
            return -1;
        }
        if (arr[index] == key) {
            return index;
        }
        return findLastOccurence(arr, index - 1, key);
    }

    public static void main(String[] args) {
        int arr[] = { 8, 3, 6, 9, 8, 10, 2, 5, 3 };
        int key = -1;
        int index = findLastOccurence(arr, arr.length - 1, key);
        if (index == -1) {
            System.out.println("Not Found");
        } else {
            System.out.println("Found at Index==>" + index);
        }
    }

}
