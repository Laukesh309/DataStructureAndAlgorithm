package top150InterviewProblem.BackTracking;

import java.util.List;

import java.util.ArrayList;

public class combinationSumSecond {

    public static void findAllUniqueCombination(int candidates[], int currentIndex, int target,
            List<Integer> tempResult,
            List<List<Integer>> finalResult) {
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(tempResult);
            finalResult.add(temp);
            return;
        }
        if (target < 0 || currentIndex >= candidates.length) {
            return;
        }

        // take
        tempResult.add(candidates[currentIndex]);
        findAllUniqueCombination(candidates, currentIndex, target - candidates[currentIndex], tempResult,
                finalResult);
        tempResult.remove(tempResult.size() - 1);
        findAllUniqueCombination(candidates, currentIndex + 1, target, tempResult, finalResult);
        return;

    }

    public static void main(String[] args) {
        int candidates[] = { 2, 3, 6, 7 }, target = 7;
        List<List<Integer>> finalResult = new ArrayList<>();
        findAllUniqueCombination(candidates, 0, target, new ArrayList<>(), finalResult);
        System.out.println(finalResult);
    }

}
