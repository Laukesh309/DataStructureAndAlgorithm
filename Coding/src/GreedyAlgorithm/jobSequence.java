package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class jobSequence {

    public static void printArray(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        Arrays.sort(arr, Comparator.comparingDouble(o -> o[0]));
        printArray(arr);
        int totalTime = 0;
        int prevProfit = 0;
        int maxProfit = 0;
        for (int i = 0; i < arr.length; i++) {
            if (totalTime == arr[i][0] && prevProfit < arr[i][1]) {
                maxProfit = maxProfit - prevProfit;
                prevProfit = arr[i][1];
                maxProfit = maxProfit + prevProfit;

            }
            if (totalTime < arr[i][0]) {
                prevProfit = arr[i][1];
                maxProfit = maxProfit + prevProfit;
                totalTime++;
            }

        }
        System.out.println(maxProfit);
    }
}
