package top150InterviewProblem.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class mergeInterval {

    public static void printTwoDimention(int intervals[][]) {
        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals[0].length; j++) {
                System.out.print(intervals[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int intervals[][] = { { 15, 18 }, { 2, 6 }, { 8, 10 }, { 1, 3 } };
        Arrays.sort(intervals, Comparator.comparingInt(item -> item[0]));
        List<int[]> result = new ArrayList<>();
        int current[] = intervals[0];
        result.add(current);
        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = current[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if (currentEnd >= nextStart) {
                current[1] = Math.max(currentEnd, nextEnd);
            } else {
                current = intervals[i];
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()]);

    }

}
