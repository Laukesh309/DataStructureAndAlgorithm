package top150InterviewProblem.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void findAllPermutation(int nums[], int currentIndex, List<List<Integer>> finalResult,
            List<Integer> tempResult) {
        if (currentIndex >= nums.length) {
            finalResult.add(new ArrayList<>(tempResult));
            return;
        }
        for (int i = currentIndex; i < nums.length; i++) {
            int temp = nums[currentIndex];
            nums[currentIndex] = nums[i];
            nums[i] = temp;
            tempResult.add(nums[currentIndex]);
            findAllPermutation(nums, currentIndex + 1, finalResult, tempResult);
            tempResult.remove(tempResult.size() - 1);
            nums[i] = nums[currentIndex];
            nums[currentIndex] = temp;

        }
        return;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        List<List<Integer>> finalResult = new ArrayList<>();
        findAllPermutation(nums, 0, finalResult, new ArrayList<>());
        System.out.println(finalResult);
    }

}
