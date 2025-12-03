package top150InterviewProblem.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class combination {

    public static void findAllCombination(int n, int k, List<List<Integer>> resullt,
            ArrayList<Integer> tempResult) {
        if (k == 0) {

            resullt.add(new ArrayList<>(tempResult));
            return;
        }
        if (n == 0) {
            return;
        }
        tempResult.add(n);
        findAllCombination(n - 1, k - 1, resullt, tempResult);
        tempResult.remove(tempResult.size() - 1);
        findAllCombination(n - 1, k, resullt, tempResult);
    }

    public static void main(String[] args) {
        int n = 1;
        int k = 1;
        List<List<Integer>> result = new ArrayList<>();
        findAllCombination(n, k, result, new ArrayList<>());
        System.out.println(result);

    }

}
