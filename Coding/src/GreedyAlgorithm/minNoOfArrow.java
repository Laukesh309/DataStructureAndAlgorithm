package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

public class minNoOfArrow {

    public static void main(String[] args) {
        int points[][] = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        Arrays.sort(points, Comparator.comparingInt(obj -> obj[1]));
        int currentIndex = 0;
        int minArrow = 0;
        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }
        while (currentIndex < points.length) {
            int currentDeadline = points[currentIndex][1];
            minArrow++;
            System.out.println("thesting");
            currentIndex++;
            while (currentIndex < points.length && points[currentIndex][0] <= currentDeadline) {
                currentIndex++;
            }

        }
        System.out.println(minArrow);
    }

}
