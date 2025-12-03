package BackTrackingTop20;

import java.util.ArrayList;

public class subSetSum {

    public static void findSubSet(int set[], int curIndex, ArrayList<ArrayList<Integer>> finalResult,
            ArrayList<Integer> tempResult, int totalSum) {
        System.out.println(curIndex + " " + set.length);
        if (totalSum == 0) {
            ArrayList<Integer> result = new ArrayList<>(tempResult);
            finalResult.add(result);
            return;
        }
        if (totalSum < 0 || curIndex >= set.length) {
            return;
        }
        tempResult.add(set[curIndex]);
        findSubSet(set, curIndex + 1, finalResult, tempResult, totalSum - set[curIndex]);
        tempResult.remove(tempResult.size() - 1);
        findSubSet(set, curIndex + 1, finalResult, tempResult, totalSum);
    }

    public static void main(String[] args) {
        int set[] = { 1, 2, 1 };
        int sum = 3;
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        findSubSet(set, 0, finalResult, new ArrayList<>(), sum);
        System.out.println(finalResult);
    }

}
