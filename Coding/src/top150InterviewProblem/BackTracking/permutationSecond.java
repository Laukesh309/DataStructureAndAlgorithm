package top150InterviewProblem.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class permutationSecond {

    public static void findAllPermutation(int nums[], int currentIndex, List<Integer> tempResut,
            List<List<Integer>> finalResult) {
        if (currentIndex >= nums.length) {
            List<Integer> temp = new ArrayList<>(tempResut);
            finalResult.add(temp);
            return;
        }
        for (int i = currentIndex; i < nums.length; i++) {
            int temp = nums[currentIndex];
            nums[currentIndex] = nums[i];
            nums[i] = temp;
            tempResut.add(nums[currentIndex]);
            findAllPermutation(nums, currentIndex + 1, tempResut, finalResult);
            tempResut.remove(tempResut.size() - 1);
            nums[i] = nums[currentIndex];
            nums[currentIndex] = temp;
        }
        return;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3 };
        List<List<Integer>> finalResult = new ArrayList<>();
        findAllPermutation(nums, 0, new ArrayList<>(), finalResult);
        System.out.println(finalResult);

    }

}
