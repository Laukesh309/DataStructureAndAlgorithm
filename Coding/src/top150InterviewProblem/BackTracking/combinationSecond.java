package top150InterviewProblem.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class combinationSecond {

    public static void findAllCombination(int n, int k, List<Integer> tempResult, List<List<Integer>> finalResult) {
        if (k == 0) {
            List<Integer> temp = new ArrayList<>(tempResult);
            finalResult.add(temp);
            return;
        }
        if (n == 0) {
            return;
        }
        tempResult.add(n);
        findAllCombination(n - 1, k - 1, tempResult, finalResult);
        tempResult.remove(tempResult.size() - 1);
        findAllCombination(n - 1, k, tempResult, finalResult);
        return;
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> finalResult = new ArrayList<>();
        findAllCombination(n, k, new ArrayList<>(), finalResult);
        System.out.println(finalResult);
    }

}
