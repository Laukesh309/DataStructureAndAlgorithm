package BackTrackingRevision;

import java.util.ArrayList;
import java.util.List;

public class combination {

    public static void findAllPossibleCombination(int n, int k, int currentValue, List<Integer> result,
            List<List<Integer>> finalResult) {
        if (k == 0) {
            ArrayList<Integer> newlist = new ArrayList<>(result);
            finalResult.add(newlist);
            return;
        }
        if (k < 0) {
            return;
        }
        for (int i = currentValue; i <= n; i++) {
            result.add(i);
            int currentIndex = result.size() - 1;
            findAllPossibleCombination(n, k - 1, i + 1, result, finalResult);
            result.remove(currentIndex);
        }
    }

    public static void main(String[] args) {
        int n = 1, k = 1;
        List<List<Integer>> finalResult = new ArrayList<>();
        findAllPossibleCombination(n, k, 1, new ArrayList<>(), finalResult);
        System.out.println(finalResult);

    }

}
