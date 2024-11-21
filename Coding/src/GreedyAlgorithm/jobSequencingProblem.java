package GreedyAlgorithm;

import java.util.HashMap;

public class jobSequencingProblem {
    int id, profit, deadline;

    jobSequencingProblem(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }

    public static void printArray(int arr[]) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static int findMaxProfit(jobSequencingProblem arr[]) {
        int result[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int currentDeadLine = arr[i].deadline;
            int currentProfit = arr[i].profit;
            if (result[currentDeadLine - 1] == 0) {
                result[currentDeadLine - 1] = currentProfit;
            } else {
                int counter = currentDeadLine - 1;
                while (counter >= 0 && result[counter] != 0) {
                    if (currentProfit > result[counter]) {
                        int temp = result[counter];
                        result[counter] = currentProfit;
                        currentProfit = temp;
                    }
                    counter--;
                }
                if (counter >= 0) {
                    result[counter] = currentProfit;
                }
            }
        }

        int totalProfit = 0;
        int totalCount = 0;
        for (int i = 0; i < result.length; i++) {
            if (result[i] > 0) {
                totalCount++;
                totalProfit += result[i];
            }
        }
        int totalResult[] = new int[2];
        totalResult[0] = totalCount;
        totalResult[1] = totalProfit;

        return totalResult;

    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 100 }, { 2, 1, 19 }, { 3, 2, 27 }, { 4, 1, 25 }, { 5, 1, 15 } };
        jobSequencingProblem result[] = new jobSequencingProblem[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = new jobSequencingProblem(arr[i][0], arr[i][1], arr[i][2]);
        }
        System.out.println(findMaxProfit(result));

    }

}
