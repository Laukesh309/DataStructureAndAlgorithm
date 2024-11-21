package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapSack {

    public static void printArray(double arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1] + " " + arr[i][2] + " " + arr[i][3]);
        }
        System.out.println();
    }

    public static double findMaxValue(int weight[], int value[], int totalWeight) {

        double result[][] = new double[value.length][4];
        for (int i = 0; i < value.length; i++) {
            result[i][0] = i;
            result[i][1] = weight[i];
            result[i][2] = value[i];
            result[i][3] = (double) (value[i]) / weight[i];
        }
        Arrays.sort(result, Comparator.comparingDouble(o -> o[3]));
        double maximumValue = 0;

        for (int i = weight.length - 1; i >= 0; i--) {
            double currentValue = result[i][2];
            double currentWight = result[i][1];
            if (totalWeight <= 0) {
                break;
            }
            if (currentWight >= totalWeight) {
                maximumValue = maximumValue + result[i][3] * totalWeight;
                totalWeight = 0;
            } else {
                maximumValue = maximumValue + currentValue;
                totalWeight = (int) (totalWeight - currentWight);
            }
        }
        return maximumValue;

    }

    public static void main(String[] args) {
        int value[] = { 8, 2, 10, 1, 9, 7, 2, 6, 4, 9 }, weight[] = { 10, 1, 7, 7, 5, 1, 8, 6, 8, 7 };
        int totalWeight = 21;
        System.out.println(findMaxValue(weight, value, totalWeight));
    }

}
