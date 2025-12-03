package recursion;

import java.util.ArrayList;
import java.util.List;

public class subset1 {

    public static void findSubSet(int num[], int curIndex, ArrayList<Integer> tempResult,
            List<List<Integer>> finalResult) {
        if (curIndex >= num.length) {
            ArrayList<Integer> result = new ArrayList<>(tempResult);
            finalResult.add(result);
            return;
        }
        tempResult.add(num[curIndex]);
        findSubSet(num, curIndex + 1, tempResult, finalResult);
        tempResult.remove(tempResult.size() - 1);
        findSubSet(num, curIndex + 1, tempResult, finalResult);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        List<List<Integer>> finalResult = new ArrayList<>();
        findSubSet(nums, 0, new ArrayList<>(), finalResult);
        System.out.println(finalResult);

    }

}
