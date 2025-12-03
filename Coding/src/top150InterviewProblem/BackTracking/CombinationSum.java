package top150InterviewProblem.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void findCombinationSum(int candidates[], int currentIndex, int target,
            List<List<Integer>> finalResult, List<Integer> tempResult) {
        if (target == 0) {
            finalResult.add(new ArrayList<>(tempResult));
            return;
        }
        if (target < 0 || currentIndex >= candidates.length) {
            return;
        }
        tempResult.add(candidates[currentIndex]);
        findCombinationSum(candidates, currentIndex, target - candidates[currentIndex], finalResult,
                tempResult);
        tempResult.remove(tempResult.size() - 1);
        findCombinationSum(candidates, currentIndex + 1, target, finalResult, tempResult);
    }

    public static void main(String[] args) {
        int candidates[] = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> finalResult = new ArrayList<>();
        findCombinationSum(candidates, 0, target, finalResult, new ArrayList<>());
        System.out.println(finalResult);
    }

}
