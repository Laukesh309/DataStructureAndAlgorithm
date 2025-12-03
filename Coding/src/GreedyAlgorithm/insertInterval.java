package GreedyAlgorithm;

import java.util.ArrayList;

public class insertInterval {

    public static void insertInterval(int intervals[][], int newInterval[]) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean isNewIntervalAdded = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!isNewIntervalAdded) {
                if (intervals[i][1] < newInterval[0]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(intervals[i][0]);
                    temp.add(intervals[i][1]);
                    result.add(temp);
                } else if (newInterval[1] < intervals[i][0]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    isNewIntervalAdded = true;
                    temp.add(newInterval[0]);
                    temp.add(newInterval[1]);
                    result.add(temp);
                    ArrayList<Integer> tempResult = new ArrayList<>();
                    tempResult.add(intervals[i][0]);
                    tempResult.add(intervals[i][1]);
                    result.add(tempResult);
                } else {
                    newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                    newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
                    System.out.println(newInterval[0]);
                    System.out.println(newInterval[1]);
                }
            } else {
                ArrayList<Integer> tempResult = new ArrayList<>();
                tempResult.add(intervals[i][0]);
                tempResult.add(intervals[i][1]);
                result.add(tempResult);
            }
        }
        int finalResult[][] = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i][0] = result.get(i).get(0);
            finalResult[i][1] = result.get(i).get(1);
        }

    }

    public static void main(String[] args) {
        int intervals[][] = { { 1, 3 }, { 6, 9 } };
        int newInterval[] = { 2, 5 };
        if (intervals.length == 0) {
            int finalResult[][] = new int[1][2];
            finalResult[0][0] = newInterval[0];
            finalResult[0][1] = newInterval[1];
            return finalResult;

        }
        if (newInterval.length == 0) {
            int finalResult[][] = new int[intervals.length][2];
            for (int i = 0; i < intervals.length; i++) {
                finalResult[i][0] = intervals[i][0];
                finalResult[i][1] = intervals[i][1];
                return finalResult;
            }
        }
        insertInterval(intervals, newInterval);

    }

}
