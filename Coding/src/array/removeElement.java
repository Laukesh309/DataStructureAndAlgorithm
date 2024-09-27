package array;

public class removeElement {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int findReplacedValue(int arr[], int k) {
        int start = 0;
        int end = arr.length - 1;
        int result = 0;
        while (start <= end) {
            while (start <= end && arr[start] != k) {
                start++;
            }
            while (end >= start && arr[end] == k) {
                result++;
                end--;
            }
            if (start < end) {
                result++;
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
            start++;
            end--;
        }
        return arr.length - result;
    }

    public static void main(String[] args) {
        int nums[] = { 1 };
        int k = 1;
        System.out.println(findReplacedValue(nums, k));
        printArray(nums);
    }

}
