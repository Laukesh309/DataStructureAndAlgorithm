package recursion.LoveBabbar;

import java.util.ArrayList;

public class permutationArray {

    public static void swap(int arr[], int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
        return;
    }

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void findAllPermutation(int arr[], int index) {
        if (index >= arr.length) {
            printArray(arr);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            findAllPermutation(arr, index + 1);
            swap(arr, index, i);

        }

    }

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4 };
        findAllPermutation(arr, 0);
    }

}
