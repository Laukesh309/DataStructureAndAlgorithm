package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FractionKnapSackProblem {

    public static void printArray(int arr[][]) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int value[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int totalWight = 50;
        int totalValue[][] = new int[value.length][4];
        for (int i = 0; i < value.length; i++) {
            totalValue[i][0] = i;
            totalValue[i][1] = value[i];
            totalValue[i][2] = weight[i];
            totalValue[i][3] = value[i] / weight[i];
        }
        Arrays.sort(totalValue, Comparator.comparingDouble(o -> o[3]));
        int tatalChoosenWeight = 0;
        int totalChoosenValue = 0;
        int rows = totalValue.length - 1;
        while (totalWight > 0 && rows >= 0) {
            int currentValue = totalValue[rows][1];
            int currentWight = totalValue[rows][2];
            if (currentWight <= totalWight) {
                totalChoosenValue = totalChoosenValue + currentValue;
                totalWight = totalWight - currentWight;
            } else {
                totalChoosenValue = totalChoosenValue + totalValue[rows][3] * totalWight;
                totalWight = totalWight - currentWight;
            }
            rows--;

        }
        System.out.println(totalChoosenValue);

        printArray(totalValue);
    }

}
