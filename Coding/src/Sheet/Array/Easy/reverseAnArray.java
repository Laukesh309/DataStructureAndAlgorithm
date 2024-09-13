package Sheet.Array.Easy;

public class reverseAnArray {

    public static void reverseArrayByRecursion(int arr[], int currentIndex) {
        System.out.println(currentIndex);
        if (currentIndex == arr.length) {
            return;
        }
        int currentIndexValue = arr[currentIndex];
        reverseArrayByRecursion(arr, currentIndex + 1);
        arr[arr.length - (currentIndex + 1)] = currentIndexValue;
        return;
    }

    public static void reverArrayTwoPointer(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 1, 2 };
        // reverseArrayByRecursion(arr, 0);
        reverArrayTwoPointer(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
