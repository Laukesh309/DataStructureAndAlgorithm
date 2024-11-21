package recursion;

import java.util.ArrayList;
import java.util.List;

public class combination {

    public static void getAllValue(int n, int k, ArrayList<Integer> currentResult,
            List<List<Integer>> finalResult) {

        if (currentResult.size() == k) {
            finalResult.add(currentResult);
            return;
        }
        if (n == 0) {
            return;
        }

        currentResult.add(n);
        getAllValue(n - 1, k, new ArrayList<>(currentResult), finalResult);
        currentResult.remove(currentResult.size() - 1);
        getAllValue(n - 1, k, new ArrayList<>(currentResult), finalResult);

    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> finalResult = new ArrayList<>();
        getAllValue(n, k, new ArrayList<>(), finalResult);
        System.out.println(finalResult);
    }

}
