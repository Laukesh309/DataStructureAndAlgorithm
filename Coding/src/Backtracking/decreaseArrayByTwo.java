package Backtracking;

public class decreaseArrayByTwo {

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void decreaseByTwo(int arr[], int currentIndex) {

        if (currentIndex >= arr.length) {
            return;
        }
        arr[currentIndex] = currentIndex + 1;
        decreaseByTwo(arr, currentIndex + 1);
        arr[currentIndex] = arr[currentIndex] - 2;

    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        decreaseByTwo(arr, 0);
        printArray(arr);

    }

}
