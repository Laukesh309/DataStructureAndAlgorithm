package DynamicProgramming;

import java.util.ArrayList;

public class zerooneknapsack {

    public static int findMaxValue(int value[], int weight[], int currentWeight, int currentIndex) {
        if (currentIndex < 0) {
            return 0;
        }
        if (currentWeight == 0) {
            return 0;
        }
        if (weight[currentIndex] <= currentWeight) {
            return Math.max(findMaxValue(value, weight, currentWeight, currentIndex - 1), value[currentIndex] +
                    findMaxValue(value, weight, currentWeight - weight[currentIndex], currentIndex - 1));
        } else {
            return findMaxValue(value, weight, currentWeight, currentIndex - 1);
        }

    }

    public static void main(String[] args) {
        int value[] = { 15, 14, 10, 45, 30 };
        int weigh[] = { 2, 5, 1, 3, 4 };
        int totalWight = 7;
        ArrayList<Integer> result = new ArrayList<>();
        System.out.println(findMaxValue(value, weigh, totalWight, value.length - 1));
    }

}
