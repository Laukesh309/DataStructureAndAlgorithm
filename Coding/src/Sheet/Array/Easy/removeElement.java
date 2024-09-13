package Sheet.Array.Easy;

public class removeElement {

    public static void printArray(int arr[]) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static int removeElement(int arr[], int k) {
        int start = 0;
        int end = arr.length - 1;
        int counter = 0;
        while (start < end) {
            while (arr[end] == k) {
                counter++;
                end--;
            }
            while (arr[start] != k) {
                start++;
            }
            if (start < end) {
                int temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
                counter++;

            }
        }
        printArray(arr);

        return counter;

    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int k = 2;
        System.out.println(removeElement(arr, k));
        printArray(arr);
    }

}
