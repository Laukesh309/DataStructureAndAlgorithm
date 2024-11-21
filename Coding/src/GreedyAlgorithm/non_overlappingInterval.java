package GreedyAlgorithm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class non_overlappingInterval {

    public static void printArray(int intervals[][]) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[i].length; j++) {
                System.out.print(intervals[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int findMinRemoval(int intervals[][]) {

        int end = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                result++;
                end = intervals[i][1];
            }
        }

        return intervals.length - result;

    }

    public static void main(String[] args) {
        int intervals[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        Arrays.sort(intervals, Comparator.comparingInt(obj -> obj[1]));
        printArray(intervals);
        System.out.println(findMinRemoval(intervals));
    }

}
