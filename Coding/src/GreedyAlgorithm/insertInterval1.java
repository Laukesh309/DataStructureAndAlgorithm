package GreedyAlgorithm;

import java.util.ArrayList;

public class insertInterval1 {

    public static void findInterval(int intervals[][], int newInterval[]) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean isNewAdded = false;
        int currentIndex = 0;
        while (currentIndex < intervals.length && newInterval.length > 0) {
            ArrayList<Integer> tempResult = new ArrayList<>();
            if (intervals[currentIndex][1] < newInterval[0]) {
                tempResult.add(intervals[currentIndex][0]);
                tempResult.add(intervals[currentIndex][1]);
                result.add(tempResult);
            } else if (newInterval[1] < intervals[currentIndex][0]) {
                tempResult.add(newInterval[0]);
                tempResult.add(newInterval[1]);
                result.add(tempResult);
                isNewAdded = true;
                break;
            } else {

                newInterval[0] = Math.min(intervals[currentIndex][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[currentIndex][1], newInterval[1]);
            }
            currentIndex++;
        }
        while (currentIndex < intervals.length) {
            ArrayList<Integer> tempResult = new ArrayList<>();
            tempResult.add(intervals[currentIndex][0]);
            tempResult.add(intervals[currentIndex][1]);
            result.add(tempResult);
            currentIndex++;
        }
        if (isNewAdded == false && newInterval.length > 0) {
            ArrayList<Integer> tempResult = new ArrayList<>();
            tempResult.add(newInterval[0]);
            tempResult.add(newInterval[1]);
            result.add(tempResult);
        }
        int finalResult[][] = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i][0] = result.get(i).get(0);
            finalResult[i][1] = result.get(i).get(1);
        }

    }

    public static void main(String[] args) {
        int intervals[][] = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int newInterval[] = { 4, 8 };
        findInterval(intervals, newInterval);

    }

}
