package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class maxLength {

    public static void printArray(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        // printArray(arr);
        Arrays.sort(arr, Comparator.comparingInt((o) -> o[1]));
        int currentSecondValue = arr[0][1];
        int totalPair = 1;
        for (int i = 1; i < arr.length; i++) {
            if (currentSecondValue < arr[i][0]) {
                totalPair += 1;
                currentSecondValue = arr[i][1];
            }
        }
        System.out.println(totalPair);
    }

}
