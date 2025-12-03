package BackTrackingTop20;

import java.util.ArrayList;

public class tugOfWar {

    public static void findSubSet(int arr[], int currentIndex, int totalSum, int currentSum,
            ArrayList<Integer> currentResult, ArrayList<ArrayList<Integer>> finalResult, int minDifference[]) {
        if (currentIndex >= arr.length) {
            return;
        }

        if (currentResult.size() == arr.length / 2) {
            int diff = Math.abs(totalSum / 2 - currentSum);
            if (diff < minDifference[0]) {
                minDifference[0] = diff;
                ArrayList<Integer> tempIndex = new ArrayList<>(currentResult);
                finalResult.set(0, tempIndex);
                return;
            }
        }
        currentResult.add(currentIndex);
        findSubSet(arr, currentIndex + 1, totalSum, currentSum + arr[currentIndex], currentResult, finalResult,
                minDifference);
        currentResult.remove(currentResult.size() - 1);
        findSubSet(arr, currentIndex + 1, totalSum, currentSum, currentResult, finalResult, minDifference);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, -3, 100, 1, 89, 54, 23, 20 };
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        int minDifference[] = new int[] { Integer.MAX_VALUE };
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        finalResult.add(null);
        findSubSet(arr, 0, totalSum, 0, new ArrayList<>(), finalResult, minDifference);
        System.out.println(finalResult);
        ArrayList<Integer> set1 = new ArrayList<>();
        ArrayList<Integer> set2 = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (finalResult.get(0).contains(i)) {
                set1.add(arr[i]);
            } else {
                set2.add(arr[i]);
            }
        }
        System.out.println(set1);
        System.out.println(set2);
    }

}
